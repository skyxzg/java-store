package com.taobao.yiwei.designpattern.state;

/**
 * 状态模式
 * 允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
 *
 * 一般来讲，当状态转换是固定的时候，适合放在context（示例中为GumballMachine类）中；
 * 然而，当转换时更动态的时候，通常就会放在状态类中，将状态转换放在状态类中的缺点是：状态类之间产生了依赖。
 *
 * 本例中State是接口，如果有共同的功能需要放在一起的话，可以使用抽象类。
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(10);

        for (int i = 0; i < 10; i++) {
            System.out.println(gumballMachine);
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
    }
}
