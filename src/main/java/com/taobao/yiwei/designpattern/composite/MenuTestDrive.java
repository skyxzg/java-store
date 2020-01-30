package com.taobao.yiwei.designpattern.composite;

/**
 * 组合模式
 * 允许你将对象组合成树形结构来表现"整体/部分"层次结构。
 * 组合能让客户以一致的方式处理个别对象以及对象组合。
 *
 * 使用组合结构，我们能把相同的操作同时应用在组合和个别对象上，忽略他们之间的差别。
 *
 * 组合模式牺牲了单一职责设计原则而换取了透明性。
 * 通过让组件的接口同时包含管理子节点和叶节点的操作，客户可以将组合和叶节点一视同仁。
 * 也就是说，一个元素究竟是组合还是叶节点，对客户是透明的。
 * 这是一个很典型的透明性和安全性的折衷案例。
 */
public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinnerMenu = new Menu("DINNER MENU", "Dinner");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Coffee");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined!");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);

        // 这里加入菜单项
        dinnerMenu.add(new MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89));
        dinnerMenu.add(dessertMenu); // 可以在一个菜单中加入子菜单，因为子菜单和菜单都是MenuComponent

        dessertMenu.add(new MenuItem(
                "Appale Pie",
                "Appale pie with a flakey crust, topped with vanilla ice cream",
                true,
                1.59));

        // 这里加入更多的菜单项

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
