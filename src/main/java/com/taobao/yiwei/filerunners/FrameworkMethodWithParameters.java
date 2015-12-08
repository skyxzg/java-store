package com.taobao.yiwei.filerunners;

import java.lang.reflect.Method;
import java.util.Map;

import org.junit.runners.model.FrameworkMethod;


public class FrameworkMethodWithParameters extends FrameworkMethod {
	
	protected Map<String, String> params;

	public FrameworkMethodWithParameters(Method method, Map<String, String> params) {
	    super(method);
	    this.params = params;
    }
	
	public boolean isRun() {
		String runFlag = params.get("isRun");
		if (runFlag.equalsIgnoreCase("yes")
				|| runFlag.equalsIgnoreCase("true")) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Object invokeExplosively(Object target, Object... parameters) throws Throwable {
		return super.invokeExplosively(target, this.params);
	}

	@Override
	public String toString() {
		return getMethod().getName() + '[' + params.get("caseName") + ":" + params.get("caseDesc") + ']';
	}

}
