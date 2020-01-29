package com.taobao.yiwei.designpattern.facade.component;

/**
 * 外观/门面模式
 * 提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
 * 遵循最小知识原则
 */
public class DvdPlayer {

    public void on() {
        System.out.println("DvdPlayer on");
    }

    public void off() {
        System.out.println("DvdPlayer off");
    }

    public void play(String movie) {
        System.out.println("DvdPlayer playing \"" + movie + "\"");
    }

    public void stop() {
        System.out.println("DvdPlayer stop");
    }

}
