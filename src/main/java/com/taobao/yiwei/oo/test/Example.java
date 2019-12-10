package com.taobao.yiwei.oo.test;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        List<Dog> dogList = new ArrayList<>();
        List<Poodle> poodleList = new ArrayList<>();

        animalList.add(new Animal());
        dogList.add(new Dog());
        poodleList.add(new Poodle());

        // 下行编译出错，只能赋值Dog和Dog子类的集合
//        List<? extends Dog> extendsDogFromAnimal = animalList;
        List<? super Dog> superDogFromAnimal = animalList;

        List<? extends Dog> extendsDogFromDog = dogList;
        List<? super Dog> superDogFromDog = dogList;

        List<? extends Dog> extendsDogFromPoolde = poodleList;
        // 下行编译出错，只能赋值Dog和Dog父类的集合
//        List<? super Dog> superDogFromPoolde = poodleList;

        // 以下三行均编译出错
//        extendsDogFromDog.add(new Animal());
//        extendsDogFromDog.add(new Dog());
//        extendsDogFromDog.add(new Poodle());
        extendsDogFromDog.add(null);

        // 下行编译出错
//        superDogFromDog.add(new Animal());
        superDogFromDog.add(new Dog());
        superDogFromDog.add(new Poodle());


    }
}
