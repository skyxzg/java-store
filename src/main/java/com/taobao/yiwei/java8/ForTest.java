package com.taobao.yiwei.java8;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhigang.xzg
 * @date 2020/1/23
 */
public class ForTest {
    public static void main(String[] args) {

        List<String> strList = Arrays.asList("hello", "world", "!");

        // 条件未命中的情况下，filter得到empty list而非null
        List<String> filterList = strList.stream().filter(str -> str.equals("test")).collect(Collectors.toList());
        System.out.println("============");
        filterList.forEach(System.out::println);
        System.out.println("============");
        System.out.println(filterList);

        // map过程中返回null
        List<String> tarList = strList.stream().map(str -> {
            if (str.equalsIgnoreCase("world")) {
                return null;
            }
            return str;
        }).collect(Collectors.toList());
        System.out.println("============");
        System.out.println(tarList);

        test1();
        test2();
    }

    private static void test1() {
        System.out.println("============");
        OffsetDateTime time1 = OffsetDateTime.now();
        System.out.println("time1:" + time1);
        prepare(time1);
        System.out.println("time2:" + time1);
    }

    private static void prepare(OffsetDateTime time) {
        time.minus(6, ChronoUnit.MONTHS);
    }

    private static void test2() {
        List<OffsetDateTime> timeList = new ArrayList<>();
        System.out.println("============");
        OffsetDateTime time = OffsetDateTime.now();
        timeList.add(time);
        System.out.println("time1:" + timeList.get(0));
        prepareList(timeList);
        System.out.println("time2:" + timeList.get(0));
        prepare(timeList.get(0));
        System.out.println("time3:" + timeList.get(0));
    }

    private static void prepareList(List<OffsetDateTime> timeList) {
        timeList.get(0).minus(6, ChronoUnit.MONTHS);
    }
}
