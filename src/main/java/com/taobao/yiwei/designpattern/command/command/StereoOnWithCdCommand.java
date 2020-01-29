package com.taobao.yiwei.designpattern.command.command;

import com.taobao.yiwei.designpattern.command.appliances.Stereo;

public class StereoOnWithCdCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCdCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
