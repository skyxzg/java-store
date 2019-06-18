package com.taobao.yiwei.java8;

/**
 * 1、Java 8 新增了接口的默认方法。简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
 *    我们只需在方法名前面加个 default 关键字即可实现默认方法。
 * 2、Java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。
 */
public class DefaultMethodsSample {
    public static void main(String[] args){
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}

interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        // 如果这个类实现了多个接口，且这些接口有相同的默认方法，可以使用super来调用指定接口的默认方法
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}
