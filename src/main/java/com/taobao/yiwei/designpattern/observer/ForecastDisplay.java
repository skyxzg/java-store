package com.taobao.yiwei.designpattern.observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherDada; // 保存主题的引用，以备取消注册时使用

    public ForecastDisplay(Subject weatherDada) {
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
        // 判断条件没有遵循任何逻辑，仅为了实验需要
        if (temperature > 79 && temperature < 81) {
            System.out.println("Forecast: Improving weather on the way");
        } else if (temperature > 81 && temperature < 83) {
            System.out.println("Forecast: Watch out for cooler, rainy weather");
        } else {
            System.out.println("Forecast: More of the same");
        }
    }
}
