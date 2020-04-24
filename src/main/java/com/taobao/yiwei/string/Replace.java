package com.taobao.yiwei.string;

public class Replace {

	public static void main(String[] args){
		String testStr = "{binary,auth},{binary,noauth}";
		System.out.println("testStr:" + testStr);
		String newStr = testStr.replace("{", "");
		System.out.println("testStr:" + testStr);
		System.out.println("newStr:" + newStr);

		test();
	}

	private static void test() {
		String oriStr = "zpuYFGxm2LxkVR3G$rgM@ph81pvBH";
		System.out.println(oriStr);
		String newStr = oriStr.replace("$", "\\$");
		System.out.println(newStr);
	}
}
