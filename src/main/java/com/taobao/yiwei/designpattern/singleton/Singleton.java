package com.taobao.yiwei.designpattern.singleton;

/**
 * 饿汉模式 - 线程安全
 */
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    // 构造函数私有，防止从外部创建
    private Singleton() {}

    public static Singleton getInstance() {
        return uniqueInstance;
    }
}
