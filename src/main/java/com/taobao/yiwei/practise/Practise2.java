package com.taobao.yiwei.practise;

import java.util.Stack;

public class Practise2 {
    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        s1.push(2);
        s1.push(1);
        s1.push(4);
        s1.push(3);
        s1.push(5);
        s1.push(4);

        Stack<Integer> s2 = sort(s1);
        System.out.println(s2);
    }

    public static Stack<Integer> sort(Stack<Integer> in) {
        if (in == null) {
            System.out.println("input can not be null");
            return null;
        }
        Stack<Integer> out = new Stack<>();

        while(!in.isEmpty()) {
            Integer tmp = in.pop();
            while(!out.isEmpty() && tmp > out.peek()) {
                in.push(out.pop());
            }
            out.push(tmp);
        }
        return out;
    }
}
