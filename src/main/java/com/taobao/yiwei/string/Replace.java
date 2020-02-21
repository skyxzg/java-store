package com.taobao.yiwei.string;

public class Replace {

	public static void main(String[] args){
		String testStr = "{binary,auth},{binary,noauth}";
		System.out.println("testStr:" + testStr);
		String newStr = testStr.replace("{", "");
		System.out.println("testStr:" + testStr);
		System.out.println("newStr:" + newStr);
	}
}
