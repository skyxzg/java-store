package com.taobao.yiwei.java8;

/**
 * 函数式接口（Functional Interface）就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为 lambda 表达式。
 */
public class FunctionalInterface {

}


@java.lang.FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}