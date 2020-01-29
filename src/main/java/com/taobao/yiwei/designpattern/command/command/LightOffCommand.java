package com.taobao.yiwei.designpattern.command.command;

import com.taobao.yiwei.designpattern.command.appliances.Light;

public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
