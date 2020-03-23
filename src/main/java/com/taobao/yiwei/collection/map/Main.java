package com.taobao.yiwei.collection.map;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

import java.util.UUID;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Calendar;
import java.util.Map.Entry;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args){

		String trimStr1 = " ab ";
		String trimStr2 = trimStr1.trim();
        System.out.println("trimStr1:" + trimStr1);
        System.out.println("trimStr2:" + trimStr2);
		
		String metrics = "";
		String[] metricArr = metrics.split("123");
		List<String> metricList = Arrays.asList(metricArr);
        System.out.println("metricArr:" + metricList);
        System.out.println("metricArr.length:" + metricArr.length);
        System.out.println("metricList:" + metricList);
        System.out.println("metricList.size:" + metricList.size());
        
       
        // 根据后缀选择对应的subDomain
        String subDomainStr = "ap-southeast-1-b-aliyun-petadata-suffix";
        String subDomain = null;
        String[] subDomainArr = subDomainStr.split(",");
        String suffix = "petadata";
        for (String ele : subDomainArr) {
            if (ele.contains(suffix)) {
                subDomain = ele;
                break;
            }
        }
        System.out.println("subDomain:" + subDomain);
		
		
		String maintainTime = "02:00-03:00";
		String[] timeArr = maintainTime.split("-");
        System.out.println("timeArr.lengh:" + timeArr.length);
        System.out.println("timeArr[0]:" + timeArr[0]);
        System.out.println("timeArr[1]:" + timeArr[1]);
        
        Date gmtTime = getGmtTime();
        Date localDate = new Date();
        System.out.println("getGmtTime:" + gmtTime);
        System.out.println("getGmtTime:" + localDate);
        System.out.println("result:" + (localDate.before(gmtTime)));
		
		// 创建一个HashSet
        HashSet<String> set = new HashSet<String>(); 
        // 添加
        boolean add = set.add("d");
        boolean add2 = set.add("d");
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(add);
        System.out.println(add2);
        System.out.println(set);

		String[] strArr = new String[] { "you", "wu" };
		List<String> testList = Arrays.asList(strArr);
		strArr[0] = "she";
		List<String> newList = new ArrayList<String>(testList);
		newList.add("test");
		strArr[0] = "me";
		System.out.println("testList:" + testList.toString());
		System.out.println("newList:" + newList.toString());
		
		
		System.out.println("".trim());
		System.out.println(" - - ".trim());
		System.out.println("  ".trim());
				
		String splitStr = "";
		System.out.println("splitStrLen=" + splitStr.split(",").length);
		
		String strLong = "1.9999";
		Double doubleNum = Double.valueOf(strLong);
		Long longNum = Math.round(doubleNum);
		System.out.println("longNum:"+longNum);
		
		String str = "vm_jp_something_etc";
		System.out.println("str=" + str);
		System.out.println("str.replace=" + str.replaceFirst("vm_jp_", "vm_intl_"));
		
		String innerInstanceId = UUID.randomUUID().toString(); //.replace("-", "").substring(0, 14);
		System.out.println("innerInstanceId:" + innerInstanceId);
		
		Date date = new Date();
		System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        try {
            date = sdf.parse("2015-11-19T13:55Z");
        } catch(Exception e) {
    		System.out.println("debug error!");
        }
		System.out.println(date);
		
		Date destroyTime = null;
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            Calendar ca = Calendar.getInstance();
            // 释放8天后，备份删除（即彻底销毁）
            ca.add(Calendar.DATE, 8);
            Date currDate = ca.getTime();
            String endDate = sdf2.format(currDate);
            destroyTime = sdf2.parse(endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("destroyTime:" + destroyTime);
		

//		System.out.println("Long.valueOf:" + Long.valueOf(null));
		
		
		MapStore mapStore = new MapStore();
		Map<String, String> data = mapStore.genernateMap();
		
		String removeStr = data.remove("002");
		data.remove("002");
		System.out.println("removeStr:" + removeStr);
		
		
//		data = mapStore.sortMapByKey(data);
//		mapStore.traverseKeySet(data);
//		mapStore.traverseKeySetIter(data);
//		mapStore.traverseEntrySet(data);
//		mapStore.traverseEntrySetIter(data);
		
		Clazz clz = new Clazz();
		List<Student> stuList = new ArrayList<Student>();
		for (int i = 0; i < 5; i++) {
			Student stu = new Student();
			stu.name = "stu" + i;
			stu.age = "1" + i;
			stuList.add(stu);
		}
		clz.id = "clz-1";
		clz.stuList = stuList;
		
		List<Student> copyStuList = new ArrayList<Student>(Arrays.asList(new Student[stuList.size()]));
		Collections.copy(copyStuList, stuList);
		
		System.out.println("size:" + stuList.size());
		int i = 0;
		for (Student stu : copyStuList) {
			System.out.println("ele:" + i);
			System.out.println(stu.name);
			System.out.println(stu.age);
			i++;
		}
		
		for (Student stu : clz.stuList) {
			System.out.println("----clz.stuList----");
			System.out.println(stu.name);
			System.out.println(stu.age);
		}
		
		for (Student stu : stuList) {
			stu.name = "change";
		}
		
		for (Student stu : clz.stuList) {
			System.out.println("----clz.stuList----");
			System.out.println(stu.name);
			System.out.println(stu.age);
		}

		for (Student stu : copyStuList) {
			System.out.println("----copyStuList----");
			System.out.println(stu.name);
			System.out.println(stu.age);
		}
		
		System.out.println("############");
		System.out.println(Color.BLUE.ordinal());
		System.out.println(Color.BLUE);
		System.out.println(Color.BLUE.toString());
		

//		Map<String, String> dataMap = mapStore.genernateMap();
//		dataMap.put("002", "everyone");
//		System.out.println(dataMap);
//		System.out.println(dataMap.get("002"));
	}
	
	public static Date getGmtTime() {
        Date gmt8 = null;
        try {
            Calendar cal = Calendar.getInstance(new SimpleTimeZone(0, "GMT"), Locale.US);
            Calendar day = Calendar.getInstance();
            day.set(Calendar.YEAR, cal.get(Calendar.YEAR));
            day.set(Calendar.MONTH, cal.get(Calendar.MONTH));
            day.set(Calendar.DATE, cal.get(Calendar.DATE));
            day.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
            day.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
            day.set(Calendar.SECOND, cal.get(Calendar.SECOND));
            gmt8 = day.getTime();
        } catch (Exception e) {
            gmt8 = null;
        }
        return gmt8;
    }
	
}


class Clazz {
	String id;
	List<Student> stuList;
}

class Student {
	String name;
	String age;
	Long num;
}


class MapStore {

	public Map<String, String> genernateMap () {
		Map<String, String> data = new HashMap<String, String>();
		data.put("001", "Hello");
		data.put("002", "world");
		data.put("003", "!");
		data.put("004", "I");
		data.put("005", "am");
		data.put("006", "vision");
		data.put("007", ".");
		return data;
	}

  public Map<String, String> sortMapByKey(Map<String, String> oriMap) {  
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
	
	public void traverseKeySet(Map<String, String> data) {
		System.out.println("Traverse by key set...");
		for (String key : data.keySet()) {
			System.out.println("key:" + key);
			System.out.println("val:" + data.get(key));
		}
	}
	
	public void traverseKeySetIter(Map<String, String> data) {
		System.out.println("Traverse by key set iter...");
		Iterator<String> iter = data.keySet().iterator();
		while (iter.hasNext()) {
		    String key = iter.next();
			System.out.println("key:" + key);
			System.out.println("val:" + data.get(key));
		}
	}
	
	public void traverseEntrySet(Map<String, String> data) {
		System.out.println("Traverse by entry set...");
		for (Entry<String, String> entry : data.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println("val:" + entry.getValue());
		}
	}
	
	public void traverseEntrySetIter(Map<String, String> data) {
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

