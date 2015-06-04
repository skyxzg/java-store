package com.taobao.yiwei.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args){
		Map<String, String> data = genernateMap();
		data = sortMapByKey(data);
		traverseKeySet(data);
		traverseKeySetIter(data);
		traverseEntrySet(data);
		traverseEntrySetIter(data);
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

    public static Map<String, String> sortMapByKey(Map<String, String> oriMap) {  
        if (oriMap == null || oriMap.isEmpty()) {  
            return null;  
        }  
        Map<String, String> sortedMap = new TreeMap<String, String>(new Comparator<String>() {  
            public int compare(String key1, String key2) {  
                return key1.compareTo(key2);  
            }});  
        sortedMap.putAll(oriMap);  
        return sortedMap;  
    } 
	
	public static void traverseKeySet(Map<String, String> data) {
		System.out.println("Traverse by key set...");
		for (String key : data.keySet()) {
			System.out.println("key:" + key);
			System.out.println("val:" + data.get(key));
		}
	}
	
	public static void traverseKeySetIter(Map<String, String> data) {
		System.out.println("Traverse by key set iter...");
		Iterator<String> iter = data.keySet().iterator();
		while (iter.hasNext()) {
		    String key = iter.next();
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
	
	public static void traverseEntrySetIter(Map<String, String> data) {
		System.out.println("Traverse by entry set iter...");
		Iterator<Entry<String, String>> iter = data.entrySet().iterator();
		Entry<String, String> entry;
		while (iter.hasNext()) {
		    entry = iter.next();
			System.out.println("key:" + entry.getKey());
			System.out.println("val:" + entry.getValue());
		}
	}
}
