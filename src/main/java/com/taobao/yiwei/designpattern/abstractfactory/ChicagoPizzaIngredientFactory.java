package com.taobao.yiwei.designpattern.abstractfactory;

import com.taobao.yiwei.designpattern.abstractfactory.cheese.Cheese;
import com.taobao.yiwei.designpattern.abstractfactory.clams.Clams;
import com.taobao.yiwei.designpattern.abstractfactory.clams.FrozenClams;
import com.taobao.yiwei.designpattern.abstractfactory.cheese.MozzarellaCheese;
import com.taobao.yiwei.designpattern.abstractfactory.dough.Dough;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.Pepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.pepperoni.SlicedPepperoni;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.PlumTomatoSauce;
import com.taobao.yiwei.designpattern.abstractfactory.dough.ThickCrustDough;
import com.taobao.yiwei.designpattern.abstractfactory.sauce.Sauce;
import com.taobao.yiwei.designpattern.abstractfactory.veggies.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new EggPlant(), new Spinach(), new BlackOlives()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam(){
        return new FrozenClams();
    }
}
