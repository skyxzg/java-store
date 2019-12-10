package com.taobao.yiwei.oo.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {
    protected Animal(){}
    double num = 1.2_234_4;
    public void test() {
        int num = new Random().nextInt(32);
        int in = ThreadLocalRandom.current().nextInt(21);
    }
}
