package com.taobao.yiwei.designpattern.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherDada; // 保存主题的引用，以备取消注册时使用

    public CurrentConditionDisplay(Subject weatherDada) {
        weatherDada.registerObserver(this);
        this.weatherDada = weatherDada;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions: temperature %.1fF degrees and %.1f%% humidity", temperature, humidity));
    }
}
