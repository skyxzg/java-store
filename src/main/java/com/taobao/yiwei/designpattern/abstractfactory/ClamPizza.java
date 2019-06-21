package com.taobao.yiwei.designpattern.abstractfactory;

import com.taobao.yiwei.designpattern.abstractfactory.veggies.Veggies;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        clams = pizzaIngredientFactory.createClam();
        veggies = pizzaIngredientFactory.createVeggies();
    }

    @Override
    public String toString() {
        String veggiesStr = Arrays.stream(veggies).map(Veggies::getName).collect(Collectors.joining(","));
        return name + "\n dough:" + dough.getName() + "\n sauce:" + sauce.getName() + "\n cheese:" + cheese.getName()
                + "\n clams:" + clams.getName() + "\n veggies:" + veggiesStr;
    }
}
