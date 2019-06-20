package com.taobao.yiwei.designpattern.strategy;

/**
 * 策略模式
 * 定义算法族，分别封装起来，让他们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。
 */
public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        Duck redhead = new RedheadDuck();
        redhead.display();
        redhead.performFly();
        redhead.performQuack();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.performFly();
        decoyDuck.performQuack();
    }
}
