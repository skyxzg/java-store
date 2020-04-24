package com.taobao.yiwei.algorithm;

import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        sortStackByStack(stack);

        System.out.println(stack);
    }

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> helper = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!helper.isEmpty()&&helper.peek()>cur){
                stack.push(helper.pop());
            }
            helper.push(cur);
        }
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }
}
