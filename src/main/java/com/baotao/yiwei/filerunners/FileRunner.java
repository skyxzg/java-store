package com.baotao.yiwei.filerunners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

public class FileRunner extends BlockJUnit4ClassRunner {

	protected final static Logger log = Logger.getLogger(FileRunner.class);
	
	private List<FrameworkMethod> children;

	public FileRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}
	
	@Override
	protected String testName(FrameworkMethod method) {
		return (method instanceof FrameworkMethodWithParameters ? method.toString() : super.testName(method));
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
			for (FrameworkMethod method : testClass.getAnnotatedMethods(Test.class)) {
				if (method.getMethod().getParameterTypes().length == 0) {
					// standard JUnit test method
					children.add(method);
					continue;
				} else {
					// parameterized test method
					List<? extends FrameworkMethod> parameterizedTestMethods;
					parameterizedTestMethods = computeParameterizedTestMethods(method);
					children.addAll(parameterizedTestMethods);
				}
			}
		}
		return children;
	}
	
	private List<FrameworkMethodWithParameters> computeParameterizedTestMethods(FrameworkMethod method) {
		Description description = describeChild(method);
		List<FrameworkMethodWithParameters> result = new ArrayList<FrameworkMethodWithParameters>();
		ParamTable paramTable = null;
		
		DataResource fileResource = description.getAnnotation(DataResource.class);
		if (fileResource == null || fileResource.file().isEmpty()) {
			throw new RuntimeException("DataResource annotation is null! method:" + method);
		}

		if (fileResource.file().endsWith(".csv")) {
			// TODO: 实现csv的解析
			throw new RuntimeException("csv文件解析未实现! file:" + fileResource.file());
		} else if (fileResource.file().endsWith(".json")) {
			// TODO: 实现json的解析
			throw new RuntimeException("json文件解析未实现! file:" + fileResource.file());
		} else if (fileResource.file().endsWith(".xls")) {
			paramTable = XlsParser.generateTable(fileResource.file(), fileResource.sheet());
		} else {
			throw new RuntimeException("Does not support this file! file:" + fileResource.file());
		}
		
		if (paramTable == null || paramTable.isEmpty())
			throw new RuntimeException("No parameter values available for method: " + method);
		
		for (int i = 0; i < paramTable.size(); i++) {
			result.add(new FrameworkMethodWithParameters(method.getMethod(), paramTable.getRow(i)));
		}
		
		return result;
	}
	
	@Override
    protected void validateTestMethods(List<Throwable> errors) {
		validatePublicVoidMethods(Test.class, false, errors);
	}
	
	private void validatePublicVoidMethods(Class<? extends Annotation> annotation, boolean isStatic, List<Throwable> errors) {
		List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(annotation);
		for (FrameworkMethod eachTestMethod : methods)
			eachTestMethod.validatePublicVoid(isStatic, errors);
	}
	
	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
		Description description = describeChild(method);

		if (method.getAnnotation(Ignore.class) != null) {
			notifier.fireTestIgnored(description);
			return;
		}
		
		if ((method instanceof FrameworkMethodWithParameters)
				&& !((FrameworkMethodWithParameters)method).isRun()) {
			notifier.fireTestIgnored(description);
			return;
		}
		
		runLeaf(methodBlock(method), description, notifier);
	}

}
