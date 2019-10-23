package com.taobao.yiwei.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 这份代码的比较是没有说服力的，更多的开销是源于自动装箱、拆箱
 * 源自：https://time.geekbang.org/column/article/11824
 */
public class LambdaBenchmark {

    public static void main(String[] args) {
        long num = 10000000L;
        long beginTime = System.currentTimeMillis();
        List<Integer> integers = prepareData(num);  // 一个大的 ArrayList，内部是随机的整形数据
        long costTime = System.currentTimeMillis() - beginTime;
        System.out.println(String.format("prepare %d numbers, and cost time is %dms", num, costTime));

        long beginTime1 = System.currentTimeMillis();
        int maxVal1 = forEachLoopMaxInteger(integers);
        long costTime1 = System.currentTimeMillis() - beginTime1;
        System.out.println(String.format("maxVal is %d, and cost time is %dms", maxVal1, costTime1));

        long beginTime2 = System.currentTimeMillis();
        int maxVal2 = lambdaMaxInteger(integers);
        long costTime2 = System.currentTimeMillis() - beginTime2;
        System.out.println(String.format("maxVal is %d, and cost time is %dms", maxVal2, costTime2));

    }

    private static List<Integer> prepareData(long num) {
        List<Integer> integers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            integers.add(rand.nextInt());
        }
        return integers;
    }

    // 基准测试 1
    private static int forEachLoopMaxInteger (List<Integer> integers) {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        return max;
    }

    // 基准测试 2
    private static int lambdaMaxInteger (List<Integer> integers) {
        //return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        return integers.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }
}
