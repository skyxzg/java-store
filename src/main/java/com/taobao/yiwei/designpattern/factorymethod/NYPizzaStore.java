package com.taobao.yiwei.designpattern.factorymethod;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        // 其余类型增加在这里
        return null;
    }
}
