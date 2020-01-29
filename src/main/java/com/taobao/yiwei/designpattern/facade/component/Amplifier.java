package com.taobao.yiwei.designpattern.facade.component;

public class Amplifier {
    private int volume;

    public void on() {
        System.out.println("Amplifier on");
    }

    public void off() {
        System.out.println("Amplifier off");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Amplifier set volume=" + volume);
    }
}
