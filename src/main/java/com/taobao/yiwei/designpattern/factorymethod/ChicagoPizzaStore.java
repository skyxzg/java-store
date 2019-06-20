package com.taobao.yiwei.designpattern.factorymethod;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        // 其余类型增加在这里
        return null;
    }
}
