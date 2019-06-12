package com.taobao.yiwei.designpattern.observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherDada; // 保存主题的引用，以备取消注册时使用

    public StatisticsDisplay(Subject weatherDada) {
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
        System.out.println(String.format("Statistics: Avg/Max/Min temperature = %.1f/%.1f/%.1f", temperature, temperature, temperature));
    }
}
