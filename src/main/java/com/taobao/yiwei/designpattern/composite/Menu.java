package com.taobao.yiwei.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// add,remove,getChild 三个方法，可以同时兼顾Menu和MenuItem，因为两者都是MenuComponent
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents;
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.menuComponents = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        // 递归打印所有菜单项及子菜单
//        Iterator<MenuComponent> iterator = menuComponents.iterator();
//        while (iterator.hasNext()) {
//            MenuComponent menuComponent = iterator.next();
//            menuComponent.print();
//        }
        menuComponents.forEach(MenuComponent::print);
    }
}
