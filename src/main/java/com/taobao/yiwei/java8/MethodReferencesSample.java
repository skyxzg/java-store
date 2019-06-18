package com.taobao.yiwei.java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReferencesSample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");


        // 1. 引用静态方法
        names.sort(String::compareTo);

        // 2. 引用某个特定对象的实例方法
        names.forEach(System.out::println);

        // 3. 引用某个类的实例方法
        // lambda
//        names.stream().map(name -> name.length()).forEach(System.out::println);
        // method reference
        names.stream().map(String::length).forEach(System.out::println);

        // 4. 引用类的构造函数
        // lambda
//        names.stream().map(name -> {
//            return new StringBuilder(name);
//        }).forEach(System.out::println);
        // method reference
        names.stream().map(StringBuilder::new).forEach(System.out::println);
    }
}
