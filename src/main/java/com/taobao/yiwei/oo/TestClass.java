package com.taobao.yiwei.oo;

@SuppressWarnings("unused")
public class TestClass {
	private static TestClassType cls1 = new TestClassType();
	private static TestClassType cls2;

	public static void main(String[] args) {
		System.out.println("begin main");
		cls2 = new TestClassType();
		TestClassType cls3 = new TestClassType();
	}
}

class TestClassType {
	public static String str = "hello";
	
	// 构造函数
	public TestClassType() {
		System.out.println("----构造函数---");
	}
	
	// 非静态
	{
		System.out.println("----非静态code---");
		str = "non-static hello";
		System.out.println(str);
	}

	// 静态
	static {
		System.out.println("---静态code---");
		str = "static hello";
		System.out.println(str);
	}
}
