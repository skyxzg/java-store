package com.taobao.yiwei.java8;

import java.util.Map;
import java.util.TreeMap;

import lombok.Data;

/**
 * @author zhigang.xzg
 * @date 2019/12/12
 */
public class LambdaSample {

    public static void main(String[] args) {
        new LambdaSample().mapSample();
    }


    private void mapSample() {

        Map<String, Zodiac> strMap = new TreeMap<>();
        strMap.put("2020", new Zodiac("鼠"));
        strMap.put("2021", new Zodiac("牛"));
        strMap.put("2022", new Zodiac("虎"));
        strMap.put("2023", new Zodiac("兔"));
        strMap.put("2024", new Zodiac("龙"));
        strMap.put("2025", new Zodiac("蛇"));

        strMap.values().removeIf(value -> "虎".equals(value.getName()));
        strMap.keySet().removeIf("2023"::equals);
        strMap.entrySet().removeIf(ele -> "2024".equals(ele.getKey()));
        strMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
        System.out.println("-------------------------");

        strMap.values().forEach(value -> {
            if ("蛇".equals(value.getName())) {
                value.setName("猫");
            }
        });
        strMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
        System.out.println("-------------------------");

        strMap.values().removeIf(value -> "猫".equals(value.getName()));
        strMap.forEach((k, v) -> System.out.println("key:" + k + ", value:" + v));
    }

    @Data
    private class Zodiac {
        private String name;

        private Zodiac(String name) {
            this.name = name;
        }
    }
}
