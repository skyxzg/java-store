package com.taobao.yiwei.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 为另一个对象提供一个替身或占位符以访问这个对象。
 *
 * 代理在结构上类似装饰器模式，但是目的不同。装饰器模式是为对象加上行为，而代理模式则是控制访问。
 *
 * 以下示例代码为java动态代理。
 * 动态代理之所以被称为动态，是因为运行时才将它的类创建出来。
 * 代码开始执行时，还没有proxy类，它是根据需要从你传入的接口集创建的。
 */
public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public void drive() {
        PersonBean joe = getPersonBeanFromDb("Joe Javabean");

        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
        System.out.println("\n");

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
        System.out.println("\n");

    }


    // 此方法需要一个PersonBean对象做参数，然后返回它的代理。因为代理和主题有相同的接口，所以我们返回一个PersonBean
    private PersonBean getOwnerProxy(PersonBean person) {
        // 创建代理，并传入指定的处理器OwnerInvocationHandler，同时处理器接收真是主题（person）作为参数
        return (PersonBean)Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    private PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean)Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    // 返回模拟数据
    private PersonBean getPersonBeanFromDb(String name) {
        PersonBean person = new PersonBeanImpl();
        person.setName(name);
        person.setGender("Male");
        person.setInterests("Swimming");
        person.setHotOrNotRating(6);
        return person;
    }
}
