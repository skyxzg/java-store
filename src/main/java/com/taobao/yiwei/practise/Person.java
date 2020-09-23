package com.taobao.yiwei.practise;

import java.lang.reflect.Method;

import lombok.Getter;
import lombok.Setter;

public class Person {

	@Getter
	@Setter
	private String name;
	
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
