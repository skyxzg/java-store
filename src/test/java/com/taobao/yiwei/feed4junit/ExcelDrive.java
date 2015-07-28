package com.taobao.yiwei.feed4junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.databene.benerator.Generator;
import org.databene.benerator.anno.AnnotationMapper;
import org.databene.benerator.anno.ThreadPoolSize;
import org.databene.benerator.engine.BeneratorContext;
import org.databene.benerator.engine.DefaultBeneratorContext;
import org.databene.benerator.wrapper.ProductWrapper;
import org.databene.commons.Period;
import org.databene.commons.converter.AnyConverter;
import org.databene.feed4junit.ChildRunner;
import org.databene.feed4junit.ErrorReportingFrameworkMethod;
import org.databene.feed4junit.Feed4JUnitConfig;
import org.databene.feed4junit.Feeder;
import org.databene.feed4junit.FrameworkMethodWithParameters;
import org.databene.feed4junit.TestInfoProvider;
import org.databene.platform.java.Entity2JavaConverter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDrive extends Feeder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Feeder.class);
	
	public static final long DEFAULT_TIMEOUT = Period.WEEK.getMillis();
	
	static {
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
	}
	
	private Feed4JUnitConfig config;
	private BeneratorContext context;
	private AnnotationMapper annotationMapper;
	
	private List<FrameworkMethod> children;

	public ExcelDrive(Class<?> testClass) throws InitializationError {
		super(testClass);
	}

	@Override
	protected String testName(FrameworkMethod method) {
		if (method instanceof FrameworkMethodWithParameters) {
			return method.toString();
		} else {
			return super.testName(method);
		}
	}
	
	// fix junit-4.12 incompatibility
    @Override
    protected Description describeChild(FrameworkMethod method) {
        return Description.createTestDescription(getTestClass().getJavaClass(),
                testName(method), method.getAnnotations());
    }
	
	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		if (children == null) {
			children = new ArrayList<FrameworkMethod>();
			TestClass testClass = getTestClass();
			AnnotationMapper annotationMapper = getAnnotationMapper();
			for (FrameworkMethod method : testClass.getAnnotatedMethods(Test.class)) {
				if (method.getMethod().getParameterTypes().length == 0) {
					// standard JUnit test method
					children.add(method);
					continue;
				} else {
					// parameterized Feed4JUnit test method
					BeneratorContext context = getContext();
					context.setGeneratorFactory(config.createDefaultGeneratorFactory());
					annotationMapper.parseClassAnnotations(testClass.getAnnotations(), context);
					List<? extends FrameworkMethod> parameterizedTestMethods;
					parameterizedTestMethods = computeParameterizedTestMethods(method.getMethod(), context);
					children.addAll(parameterizedTestMethods);
				}
			}
		}
		return children;
	}

	/** this is needed to make the runChild() method public and thus accessible from other classes, especially {@link ChildRunner}. */
	@Override
	public void runChild(FrameworkMethod method, RunNotifier notifier) {
		Description description = describeChild(method);
		if (method.getAnnotation(Ignore.class) != null) {
			notifier.fireTestIgnored(description);
		} else {
			if ((method instanceof CustomMethod)
					&& !((CustomMethod)method).isRun()) {
				notifier.fireTestIgnored(description);
			} else {
				runLeaf(methodBlock(method), description, notifier);
			}
		}
	}

	private List<FrameworkMethodWithParameters> computeParameterizedTestMethods(Method method, BeneratorContext context) {
		Integer threads = getThreadCount(method);
		long timeout = getTimeout(method);
		List<FrameworkMethodWithParameters> result = new ArrayList<FrameworkMethodWithParameters>();
		Class<?>[] parameterTypes = method.getParameterTypes();
		AnnotationMapper annotationMapper = getAnnotationMapper();
		TestInfoProvider infoProvider = getConfig().getInfoProvider();
		try {
			Generator<Object[]> paramGenerator = annotationMapper.createAndInitMethodParamsGenerator(method, context);
			Class<?>[] expectedTypes = parameterTypes;
			ProductWrapper<Object[]> wrapper = new ProductWrapper<Object[]>();
			int count = 0;
			while ((wrapper = paramGenerator.generate(wrapper)) != null) {
				Object[] generatedParams = wrapper.unwrap();
				if (generatedParams.length > expectedTypes.length) // imported data may have more columns than the method parameters, ...
					generatedParams = Arrays.copyOfRange(generatedParams, 0, expectedTypes.length); // ...so cut them
				for (int i = 0; i < generatedParams.length; i++) {
					generatedParams[i] = Entity2JavaConverter.convertAny(generatedParams[i]);
					generatedParams[i] = AnyConverter.convert(generatedParams[i], parameterTypes[i]);
				}
				// generated params may be to few, e.g. if an XLS row was imported with trailing nulls, 
				// so create an array of appropriate size
				Object[] usedParams = new Object[parameterTypes.length];
				System.arraycopy(generatedParams, 0, usedParams, 0, Math.min(generatedParams.length, usedParams.length));
				String info = infoProvider.testInfo(method, usedParams);
				result.add(new CustomMethod(method, usedParams, threads, timeout, info));
				count++;
			}
			if (count == 0)
				throw new RuntimeException("No parameter values available for method: " + method);
		} catch (Exception e) {
			LOGGER.error("Error creating test parameters", e);
			String info = infoProvider.errorInfo(method, e);
			result.add(new ErrorReportingFrameworkMethod(method, e, info));
		}
		return result;
	}
	
	

	private static Integer getThreadCount(Method method) {
		ThreadPoolSize methodAnnotation = method.getAnnotation(ThreadPoolSize.class);
		if (methodAnnotation != null)
			return methodAnnotation.value();
		Class<?> testClass = method.getDeclaringClass();
		ThreadPoolSize classAnnotation = testClass.getAnnotation(ThreadPoolSize.class);
		if (classAnnotation != null)
			return classAnnotation.value();
		return null;
	}

	private static long getTimeout(Method method) {
		return DEFAULT_TIMEOUT;
	}
	
	private Feed4JUnitConfig getConfig() {
		if (this.config == null)
			init();
		return this.config;
	}
	
	public BeneratorContext getContext() {
		if (this.config == null)
			init();
		return this.context;
	}
	
	private AnnotationMapper getAnnotationMapper() {
		if (this.config == null)
			init();
		return this.annotationMapper;
	}
	
	private void init() {
		this.config = new Feed4JUnitConfig();
		this.context = new DefaultBeneratorContext();
		this.annotationMapper = new AnnotationMapper(context.getDataModel(), config.getPathResolver());
	}
}
