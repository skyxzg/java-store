package com.taobao.yiwei.designpattern.facade;

import com.taobao.yiwei.designpattern.facade.component.*;

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
