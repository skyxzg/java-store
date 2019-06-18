package com.taobao.yiwei.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口（Functional Interface）就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 一开始也被叫做SAM类型的接口（Single Abstract Method）
 * 函数式接口可以被隐式转换为 lambda 表达式。
 * 使用 @FunctionalInterface 注释可以确保，如果在未来更改该接口时意外违反抽象方法数量规则，您会获得错误消息。
 *
 * 更多：
 * 为什么会单单从接口中定义出此类接口呢？
 * 原因是在Java Lambda的实现中， 开发组不想再为Lambda表达式单独定义一种特殊的Structural函数类型，称之为箭头类型（arrow type），
 * 依然想采用Java既有的类型系统(class, interface, method等)， 原因是增加一个结构化的函数类型会增加函数类型的复杂性，破坏既有的Java类型，
 * 并对成千上万的Java类库造成严重的影响。 权衡利弊， 因此最终还是利用SAM 接口作为 Lambda表达式的目标类型。
 * JDK中已有的一些接口本身就是函数式接口，如Runnable。 JDK 8中又增加了java.util.function包， 提供了常用的函数式接口。
 * 函数式接口代表的一种契约， 一种对某个特定函数类型的契约。 在它出现的地方，实际期望一个符合契约要求的函数。 Lambda表达式不能脱离上下文而存在，
 * 它必须要有一个明确的目标类型，而这个目标类型就是某个函数式接口。
 */
@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}


public class FunctionalInterfaceSample {
    public static void main(String[] args) {

        // 匿名内部类
        anonymousInnerClass();

        // lambda表达式
        lambdaExpression();

        // Java8 以前的内置函数式接口
        oldInnerFunctionalInterface();

        // Java8 新增的内置函数式接口
        newInnerFunctionalInterface();

        // 自定义函数式接口
        customFunctionalInterface();
    }


    private static void customFunctionalInterface() {

        System.out.println("======== 自定义函数式接口 begin ========");

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayMessage("world");

        System.out.println("======== 自定义函数式接口 end ========");
    }


    private static void newInnerFunctionalInterface() {
        System.out.println("======== Java8 内置函数式接口 begin ========");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println("输出所有数据：");
//        Predicate<Integer> predicate = n -> true;
        eval(list, n -> true);

        System.out.println("输出所有偶数：");
//        Predicate<Integer> predicate1 = n -> n%2 == 0;
        eval(list, n -> n%2 == 0);

        System.out.println("输出大于3的所有数字：");
//        Predicate<Integer> predicate2 = n -> n > 3;
        eval(list, n -> n > 3);


        System.out.println("======== Java8 内置函数式接口 end ========");
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }


    /**
     * 内置函数式接口
     * 1. Java8 之前已经有的函数式接口，如Runnable、Callable、Comparator等
     * 2. Java8 新增的内置函数式接口，在java.util.function包下，大致分了四类：
     *    - Function: 接收参数，并返回结果，主要方法 R apply(T t)
     *    - Consumer: 接收参数，无返回结果, 主要方法为 void accept(T t)
     *    - Supplier: 不接收参数，但返回结构，主要方法为 T get()
     *    - Predicate: 接收参数，返回boolean值，主要方法为 boolean test(T t)
     */
    private static void oldInnerFunctionalInterface() {

        System.out.println("======== 函数式接口写法 begin ========");
        final int times = 5;

        Runnable runnable = () -> {
            for (int i = 0; i < times; i++) {
                System.out.println("this is " + i + ".");
            }
        };
        System.out.println("I am main.");
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            // 阻塞主线程，等待子线程结束
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======== 函数式接口写法 end ========");
    }


    private static void lambdaExpression() {
        System.out.println("======== lambda 表达式改写 begin ========");
        final int times = 5;

        Thread thread = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                System.out.println("this is " + i + ".");
            }
        });
        System.out.println("I am main.");
        thread.start();

        try {
            // 阻塞主线程，等待子线程结束
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======== lambda 表达式改写 end ========");
    }

    /**
     * 匿名内部类
     * 格式：
     *   new 类名或者接口名() {
     *       重写方法();
     *   }
     *
     * 使用场景：
     * 1. 只需要获取一次实例的地方，简化代码，比如Runnable，（只针对重写一个方法时使用，需要重写多个方法时不建议使用）
     * 2. 当你想使用一个类的protected方法时，但是又不和这个类在同一个包下，是没法直接调用的。
     *    一般的做法是，写个类继承这个类，这样就能调用该父类的protected方法了，但其实只是想调用这个方法而已，不需要这么麻烦。
     *    而匿名内部类可以很简洁的做到，声明一个匿名类继承该类，并定义一个方法，该方法中用super调用那个父类方法即可。
     *    在spring-boot中的HttpMessageConverts里有用到这种方法。
     */
    private static void anonymousInnerClass() {
        System.out.println("======== 匿名内部类 begin ========");
        final int times = 5;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    System.out.println("this is " + i + ".");
                }
            }
        });
        System.out.println("I am main.");
        thread.start();

        try {
            // 阻塞主线程，等待子线程结束
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("======== 匿名内部类 end ========");
    }

}

