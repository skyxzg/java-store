package com.taobao.yiwei.designpattern.command;

import com.taobao.yiwei.designpattern.command.appliances.CeilingFan;
import com.taobao.yiwei.designpattern.command.appliances.Light;
import com.taobao.yiwei.designpattern.command.appliances.Stereo;
import com.taobao.yiwei.designpattern.command.command.*;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        Stereo stereo = new Stereo();

        // 创建所有的电灯命令对象
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        // 创建吊扇的开关命令
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // 创建音响的开关命令
        StereoOnWithCdCommand stereoOnWithCD = new StereoOnWithCdCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

        System.out.println("=================");
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        System.out.println("=================");
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);

        System.out.println("=================");
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        System.out.println("=================");
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.undoButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}
