package com.taobao.yiwei.practise;

import java.lang.reflect.Method;

public class Person {
	
    public static void main(String[] args) {
    	try {
        	Class<?> klass = Class.forName("com.taobao.yiwei.practise.Person");
        	Method method = klass.getMethod("walk");
            method.invoke(klass.newInstance());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	public void walk() {
		System.out.println("I am walking.");
	}
}
