package com.taobao.yiwei.java8;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * Optional 类的引入很好的解决空指针异常。以避免代码中很多丑陋的判空操作。
 *
 * 使用Java8 Optional 的正确姿势，参考： http://www.importnew.com/22060.html
 * 当我们还在以如下几种方式使用 Optional 时, 就得开始检视自己了
 *  1. 调用 isPresent() 方法时
 *  2. 调用 get() 方法时
 *  3. Optional 类型作为类/实例属性时
 *  4. Optional 类型作为方法参数时
 */
public class OptionalSample {

    public static void main(String[] args) {
        //创建Optional实例，也可以通过方法返回值得到。
        Optional<String> name = Optional.of("Sanaulla");

        //创建没有值的Optional实例，例如值为'null'
        Optional empty = Optional.ofNullable(null);

        //isPresent方法用来检查Optional实例是否有值。
        if (name.isPresent()) {
            //调用get()返回Optional值。
            System.out.println(name.get());
        }

        try {
            //在Optional实例上调用get()抛出NoSuchElementException。
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        //ifPresent方法接受lambda表达式参数。
        //如果Optional值不为空，lambda表达式会处理并在其上执行操作。
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });

        //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        //orElseGet与orElse类似，区别在于传入的默认值。
        //orElseGet接受lambda表达式生成默认值。
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(() -> "Default Value"));

        try {
            //orElseThrow与orElse方法类似，区别在于返回值。
            //orElseThrow抛出由传入的lambda表达式/方法生成异常。
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        //map方法通过传入的lambda表达式修改Optonal实例默认值。
        //lambda表达式返回值会包装为Optional实例。
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
        //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
        //但是flatMap方法的lambda返回值总是Optional类型。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));

        //filter方法检查Optiona值是否满足给定条件。
        //如果满足返回Optional实例值，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));

        //另一个示例，Optional值不满足给定条件。
        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        System.out.println(shortName.orElse("The name is less than 6 characters"));

    }
}

class ValueAbsentException extends Throwable {
    public ValueAbsentException() {
        super();
    }
    public ValueAbsentException(String msg) {
        super(msg);
    }
    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}
