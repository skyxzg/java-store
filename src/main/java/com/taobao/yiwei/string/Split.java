package com.taobao.yiwei.string;

public class Split {

	public static void main(String[] args){
		String str = "beijing,shanghai,hangzhou,shenzhen";
		String[] citys = str.split(",");
		for (String city : citys) {
			System.out.println("city:" + city);
		}
	}
}
