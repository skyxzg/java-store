package com.taobao.yiwei.designpattern.abstractfactory;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.name = "New York Style Cheese Pizza";
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.name = "New York Style Clam Pizza";
        }

        return pizza;
    }
}
