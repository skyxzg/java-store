package com.taobao.yiwei.designpattern.adapter;

/**
 * 适配器模式
 * 将一个类的接口，转换成客户期望的另一个接口。适配器让与原本接口不兼容的类可以合作无间。
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe TurkeyAdapter says...");
        // testDuck方法根本不知道，这其实是一只假装成鸭子的火鸡
        testDuck(turkeyAdapter);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
