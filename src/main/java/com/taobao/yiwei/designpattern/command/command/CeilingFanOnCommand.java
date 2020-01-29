package com.taobao.yiwei.designpattern.command.command;

import com.taobao.yiwei.designpattern.command.appliances.CeilingFan;

public class CeilingFanOnCommand implements Command{
    private CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
