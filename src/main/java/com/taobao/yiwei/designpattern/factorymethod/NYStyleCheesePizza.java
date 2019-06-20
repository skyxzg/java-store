package com.taobao.yiwei.designpattern.factorymethod;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "Ny Style Sauce an Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
