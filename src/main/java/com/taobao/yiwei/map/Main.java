package com.taobao.yiwei.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args){
		Map<String, String> data = genernateMap();
		traverseKeySet(data);
		traverseEntrySet(data);
	}
	
	public static Map<String, String> genernateMap () {
		Map<String, String> data = new HashMap<String, String>();
		data.put("001", "hello");
		data.put("002", "world");
		data.put("003", "i");
		data.put("004", "am");
		data.put("005", "vision");
		return data;
	}
	
	public static void traverseKeySet(Map<String, String> data) {
		System.out.println("Traverse by key set...");
		for (String key : data.keySet()) {
			System.out.println("key:" + key);
			System.out.println("val:" + data.get(key));
		}
	}
	
	public static void traverseEntrySet(Map<String, String> data) {
		System.out.println("Traverse by entry set...");
		for (Entry<String, String> entry : data.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println("val:" + entry.getValue());
		}
	}
}
