package com.taobao.yiwei.oo;

import java.io.IOException;
import java.util.*;

public class TestSample {
    public static void main(String[] args) {

        System.out.println(Planet.valueOf("MARS").code());
        for (Planet planet : Planet.values()) {
            System.out.println(planet.name() + ":" + planet.ordinal() + ":" + planet.code());
        }
        RuntimeException re;
        IOException ioe;
        Error e;
//        new TestSample().test1();
//        new TestSample().test2();
//        new TestSample().test3();
//        new TestSample().test4();
//        new TestSample().test5();
//        TimeUnit.SECONDS.sleep(10);

        Map map;
        List list;
        Collection collection;
        Collections collections;
        Stack stack;
    }

    private void test1() throws Exception {

    }

    private void test2() throws RuntimeException {

    }

    private void test3() throws TestException {

    }

    private void test4() throws IOException {

    }

    private void test5() throws IllegalArgumentException {

    }

    private class TestException extends Exception {

    }
}
