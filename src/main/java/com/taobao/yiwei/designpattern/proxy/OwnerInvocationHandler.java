package com.taobao.yiwei.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * InvocationHandler并不是proxy，而是一个帮助proxy的类，proxy会把调用转发给它处理。
 * proxy本身是利用静态的Proxy.newProxyInstance()方法在运行时动态创建的。
 */
public class OwnerInvocationHandler implements InvocationHandler {
    private PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    // 每次proxy的方法被调用，就会导致proxy调用此方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        // 这里控制方法调用
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            // 如果真正主题抛出异常的话，就会执行这里
            e.printStackTrace();
        }
        // 如果调用其他方法，一律不理
        return null;
    }
}
