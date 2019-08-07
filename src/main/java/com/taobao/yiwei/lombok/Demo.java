package com.taobao.yiwei.lombok;

public class Demo {
    public static void main(String[] args) {
        // test callSuper
        FreshMan freshMan1 = new FreshMan();
        freshMan1.setId(1001L);
        freshMan1.setName("James");
        freshMan1.setMail("james@gmail.com");
        freshMan1.setScore(95);
        freshMan1.setAddr("college street 5#");
        System.out.println(freshMan1);

        FreshMan freshMan2 = new FreshMan();
        freshMan2.setId(1002L);
        freshMan2.setName("Kevin");
        freshMan2.setMail("kevin@gmail.com");
        freshMan2.setScore(95);
        freshMan2.setAddr("college street 5#");
        System.out.println(freshMan2);

        System.out.println(freshMan1.equals(freshMan2));
    }
}
