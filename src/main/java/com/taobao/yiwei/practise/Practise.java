package com.taobao.yiwei.practise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhigang.xzg on 17/6/29.
 */
public class Practise {

	
    public static void main(String[] args) {
    	
    	String test1 = "prepaid_petadata";
    	String test2 = "prepaid_petadat";
    	System.out.println("result:" + new Date(System.currentTimeMillis()));

    	System.out.println("----------debug-----------");
    	
    	List<String> strList = new ArrayList<String>();
    	strList.add("one");
    	strList.add("two");
    	strList.add("three");
    	String[] stringArr = new String[strList.size()];
    	String[] strArr = strList.toArray(stringArr);

    	System.out.println("strList.contains:" + strList.contains("two"));
    	
    	System.out.println("----------stringArr-----------");
    	for (String str : stringArr) {
    		System.out.println("str:" + str);
    	}
    	System.out.println("----------strArr-----------");
    	for (String str : strArr) {
    		System.out.println("str:" + str);
    	}
    	
//    	List<Car> carList = new ArrayList<Car>();
//    	for (int i = 0; i < 3; i++) {
//    		Car car = new Car();
//    		car.name = "car_" + i;
//    		carList.add(car);
//    	}
//    	Car targetCar = carList.get(1);
//    	carList.add(targetCar);
//    	for (Car car : carList) {
//    		System.out.println(car.name);
//    	}
//    	carList.get(1).name = "new name";
//    	for (Car car : carList) {
//    		System.out.println(car.name);
//    	}
    }
    

}

class Car {
	public String name;
}
