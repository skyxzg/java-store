package com.taobao.yiwei.designpattern.singleton;

/**
 * 懒汉模式 - 懒加载，通过双重检查锁（double-checked locking）保证线程安全
 */
public class SingletonLazy {
    private volatile static SingletonLazy uniqueInstance = null;  // volatile确保内存可见性

    // 构造函数私有，防止从外部创建
    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (uniqueInstance == null) {  // 这里多做一次check，是为了避免每次执行该方法都进入同步代码块，减少锁开销
            synchronized (SingletonLazy.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonLazy();
                }
            }
        }
        return uniqueInstance;
    }
}
