package com.taobao.yiwei.string;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.Set;

public class Split {

	public static void main(String[] args){
		String str = "beijing,shanghai,hangzhou,shenzhen";
		String[] citys = str.split(",");
		for (String city : citys) {
			System.out.println("city:" + city);
		}

//		BitSet moby = ;

	}
}
