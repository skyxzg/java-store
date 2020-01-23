package com.taobao.yiwei.java8;

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

        List<String> filterList = strList.stream().filter(str -> str.equals("test")).collect(Collectors.toList());

        System.out.println("============");
        filterList.forEach(System.out::println);

        System.out.println("============");
        System.out.println(filterList);
    }
}
