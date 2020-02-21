package com.taobao.yiwei.oo;

public class OverrideSample {

    public static void main(String[] args) {
        Animal a = new Animal(); // Animal 对象
        Animal b = new Dog(); // Dog 对象

        a.run(); // 执行 Animal 类的方法
        b.run(); //执行 Dog 类的方法 （编译期间，因为Animal类中存在move方法，所以能编译成功，然而运行时，Java虚拟机(JVM)指定对象的类型并且运行该对象的方法。）
        //b.test(); //编译期间，因为Animal类中不存在bark方法，所以报错

        a.runAndJump();
        b.runAndJump();
    }

}

class Animal {

    public void run() {
        System.out.println("动物可以跑");
    }

    public void jump() {
        System.out.println("动物可以跳");
    }

    public void runAndJump() {
        run();
        jump();
    }

}

class Dog extends Animal {

    @Override
    public void run() {
        //	   super.move();  //应用super类的方法
        System.out.println("狗可以跑");
    }

    public void test() {
        runAndJump();
    }

}

