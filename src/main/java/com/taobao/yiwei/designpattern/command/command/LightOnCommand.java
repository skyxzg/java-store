package com.taobao.yiwei.designpattern.command.command;

import com.taobao.yiwei.designpattern.command.appliances.Light;

public class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
