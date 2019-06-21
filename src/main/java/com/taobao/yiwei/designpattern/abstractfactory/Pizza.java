package com.taobao.yiwei.designpattern.abstractfactory;

import com.taobao.yiwei.designpattern.abstractfactory.cheese.Cheese;
import com.taobao.yiwei.designpattern.abstractfactory.clams.Clams;
import com.taobao.yiwei.designpattern.abstractfactory.dough.Dough;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.Pepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.Sauce;
import com.taobao.yiwei.designpattern.abstractfactory.veggies.Veggies;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
