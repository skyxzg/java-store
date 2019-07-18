package com.taobao.yiwei.lombok;

public class Demo {
    public static void main(String[] args) {
        // test callSuper
        FreshMan freshMan = new FreshMan();
        freshMan.setId(1001L);
        freshMan.setName("James");
        freshMan.setMail("james@gmail.com");
        freshMan.setScore(95);
        freshMan.setAddr("college street 5#");
        System.out.println(freshMan);
    }
}
