package com.taobao.yiwei.effectivejava;

public class AutoBoxing {
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        long sum1 = sum1();
        long timePoint1 = System.currentTimeMillis();
        long sum2 = sum2();
        long timePoint2 = System.currentTimeMillis();

        System.out.println("sum1 = " + sum1 + ", cost time: " + (timePoint1-beginTime) + "ms");
        System.out.println("sum2 = " + sum2 + ", cost time: " + (timePoint2-timePoint1) + "ms");
    }

    /**
     * 不必要的自动装箱
     * @return
     */
    private static long sum1() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 优化后
     * @return
     */
    private static long sum2() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
