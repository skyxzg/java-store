package com.taobao.yiwei.designpattern.command.command;

import com.taobao.yiwei.designpattern.command.appliances.Stereo;

public class StereoOffCommand implements Command{
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
