package com.taobao.yiwei.designpattern.template.sample;

public abstract class CaffineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customWantCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Bolling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 钩子方法。子类可以决定是否覆盖
    boolean customWantCondiments() {
        return true;
    }
}
