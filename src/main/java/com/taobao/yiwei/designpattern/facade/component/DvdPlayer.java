package com.taobao.yiwei.designpattern.facade.component;

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
