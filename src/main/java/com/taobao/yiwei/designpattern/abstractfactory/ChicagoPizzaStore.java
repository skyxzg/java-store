package com.taobao.yiwei.designpattern.abstractfactory;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.name = "Chicago Style Cheese Pizza";
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.name = "Chicago Style Clam Pizza";
        }

        return pizza;
    }
}
