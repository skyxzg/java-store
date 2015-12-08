package com.taobao.yiwei.feed4junit;

import java.lang.reflect.Method;

import org.databene.feed4junit.FrameworkMethodWithParameters;

public class CustomMethod extends FrameworkMethodWithParameters {
	
	public CustomMethod(Method method, Object[] parameters,
			Integer threadPoolSize, long timeout, String info) {
		super(method, parameters, threadPoolSize, timeout, info);
	}

	public boolean isRun() {
		if ("yes".equals(parameters[2])
				|| "YES".equals(parameters[2])
				|| "true".equals(parameters[2])
				|| "TRUE".equals(parameters[2])) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.getMethod().getName() + '[' + parameters[0].toString() + ":" + parameters[1].toString() + ']';
	}

}
