package com.taobao.yiwei.designpattern.command.appliances;

public class CeilingFan {
    private String name;

    public CeilingFan(String name) {
        this.name = name;
    }

    public void high() {
        System.out.println(name + " ceilingFan high!");
    }

    public void medium() {
        System.out.println(name + " ceilingFan medium!");
    }

    public void low() {
        System.out.println(name + " ceilingFan low!");
    }

    public void on() {
        System.out.println(name + " ceilingFan on!");
    }

    public void off() {
        System.out.println(name + " ceilingFan off!");
    }

    public void getSpeed() {
        System.out.println(name + " ceilingFan getSpeed!");
    }
}
