package com.taobao.yiwei.designpattern.command.command;


public class NoCommand implements Command{

    @Override
    public void execute() {
        System.out.println("Nothing happens!");
    }

    @Override
    public void undo() {
        System.out.println("Nothing happens!");
    }
}
