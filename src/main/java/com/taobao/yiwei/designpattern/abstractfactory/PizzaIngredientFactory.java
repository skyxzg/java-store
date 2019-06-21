package com.taobao.yiwei.designpattern.abstractfactory;

import com.taobao.yiwei.designpattern.abstractfactory.cheese.Cheese;
import com.taobao.yiwei.designpattern.abstractfactory.clams.Clams;
import com.taobao.yiwei.designpattern.abstractfactory.dough.Dough;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.Pepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.Sauce;
import com.taobao.yiwei.designpattern.abstractfactory.veggies.Veggies;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
