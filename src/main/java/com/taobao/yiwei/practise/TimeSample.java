package com.taobao.yiwei.practise;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class TimeSample {
    public static void main(String[] args) {
        Long time = null;
        Timestamp time1 = new Timestamp(1587807703000L);
        Timestamp time2 = new Timestamp(1587808556159L);
        //Timestamp time3 = new Timestamp(time/100);
        System.out.println(time1.before(time2));

        //String testStr = "zone1,zone2;zone3";
        //String testStr = "zone1,zone2";
        //String testStr = "zone1";
        String testStr = "";


        String a = "ab"; String b = "a" + "b";
        System.out.println(a==b);

        Stream.of(testStr.split(";"))
            .flatMap(zoneStr -> Stream.of(zoneStr.split(",")))
            .forEach(System.out::println);

        //String[] arr = new String[]{"df", "sdfas", "sd"};
        List<Object> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add(234);
        print(list.toArray());
        //print(list.toArray(new Object[list.size()]));
    }

    private static void print(Object... args) {
        for (Object object : args) {
            System.out.println(object);
        }
    }
}
