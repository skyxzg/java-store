package com.taobao.yiwei.designpattern.template;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 模板方法模式
 * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 *
 * 好莱坞原则：别调用（打电话给）我们，我们会调用（打电话给）你。
 * 工厂方法、观察者，这些模式也采用了好莱坞原则。
 *
 * 应用场景举例：java集合类的排序方法。集合元素只要实现Comparable的compareTo方法即可。
 *
 * 策略模式和模板方法模式都封装算法，一个用组合，一个用继承。
 * 工厂方法是模板方法的一种特殊版本。
 */
public abstract class TemplatePattern {

    // 模板方法，声明为final，避免子类覆盖后改变算法顺序。
    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    // 原语操作，由具体子类实现
    abstract void primitiveOperation1();

    // 原语操作，由具体子类实现
    abstract void primitiveOperation2();

    // 这个具体的方法被定义在抽象模板类中。将它声明为final，可以避免子类覆盖它。
    final void concreteOperation() {
        // implement
    }

    // 这是一个具体的方法，但什么也不做。我们称这种方法为"hook"。子类可以视情况决定要不要覆盖它们。
    void hook() {}
}
