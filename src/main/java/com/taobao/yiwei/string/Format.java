package com.taobao.yiwei.string;

import java.util.Locale;

public class Format {

	private static  String FORMAT_STRING = "hello %s, welcome!";

	public static void main(String[] args) {
		double e = Math.E;
		System.out.format("%f%n", e);
		System.out.format(Locale.GERMANY, "%-10.4f%n", e); // 指定本地为德国（GERMANY）
		
		String str = String.format(Locale.CHINA, "%-10.4f", e);
		System.out.println(str);
		
		System.out.printf(Locale.US, "%-10.4f", e);

		formatTest("");
	}

	private static void formatTest(String custom) {
		System.out.println(String.format(FORMAT_STRING, custom));
	}

}
