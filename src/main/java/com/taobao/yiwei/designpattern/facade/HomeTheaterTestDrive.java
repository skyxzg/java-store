package com.taobao.yiwei.designpattern.facade;

import com.taobao.yiwei.designpattern.facade.component.*;

/**
 * 外观/门面模式
 * 提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
 *
 * 最少知识原则：减少对象之间的交互
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        // 实例化组件
        Amplifier amplifier = new Amplifier();
        CdPlayer cdPlayer = new CdPlayer();
        DvdPlayer dvdPlayer = new DvdPlayer();
        PopcornPopper popper = new PopcornPopper();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        Tuner tuner = new Tuner();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amplifier, cdPlayer, dvdPlayer, popper, projector,
                screen, lights, tuner);
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}
