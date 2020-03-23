package com.taobao.yiwei.algorithm.stringmatching;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        Set<String> inSet = new HashSet<>();

        Set<Long> outSet = test(inSet);
        System.out.println(outSet);
    }

    private static Set<Long> test(Set<String> inSet) {
        return inSet.stream().map(Long::valueOf).collect(Collectors.toSet());
    }
}
