package com.taobao.yiwei.designpattern.abstractfactory;

import com.taobao.yiwei.designpattern.abstractfactory.cheese.Cheese;
import com.taobao.yiwei.designpattern.abstractfactory.cheese.ReggianoCheese;
import com.taobao.yiwei.designpattern.abstractfactory.clams.Clams;
import com.taobao.yiwei.designpattern.abstractfactory.clams.FreshClams;
import com.taobao.yiwei.designpattern.abstractfactory.dough.*;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.Pepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.SlicedPepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.MarinaraSauce;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.Sauce;
import com.taobao.yiwei.designpattern.abstractfactory.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam(){
        return new FreshClams();
    }
}
