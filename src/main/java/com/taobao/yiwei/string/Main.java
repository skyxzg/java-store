package com.taobao.yiwei.string;

public class Main {

	public static void main(String[] args){
		String testStr = "{binary,auth},{binary,noauth}";
		System.out.println(testStr);
		testStr = testStr.replace("{", "");
		System.out.println(testStr);
	}
}
