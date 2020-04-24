package com.taobao.yiwei.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {
    private List<TaskHook<String>> preTaskHooks = new ArrayList<>();
    private List<TaskHook<String>> postTaskHooks = new ArrayList<>();

    public static void main(String[] args) {

        Sample sample = new Sample();

        sample.registerPreTaskHook(new TaskHook<>(2, str -> printMethod(str + " first2", 2)));
        sample.registerPreTaskHook(new TaskHook<>(2, str -> printMethod(str + " second2", 2)));
        sample.registerPreTaskHook(new TaskHook<>(1, str -> printMethod(str, 1)));
        sample.registerPreTaskHook(new TaskHook<>(2, str -> printMethod(str + " third2", 2)));
        sample.registerPreTaskHook(new TaskHook<>(0, str -> printMethod(str, 0)));

        sample.registerPostTaskHook(new TaskHook<>(2, str -> printMethod(str + " first2", 2)));
        sample.registerPostTaskHook(new TaskHook<>(2, str -> printMethod(str + " second2", 2)));
        sample.registerPostTaskHook(new TaskHook<>(1, str -> printMethod(str, 1)));
        sample.registerPostTaskHook(new TaskHook<>(0, str -> printMethod(str, 0)));
        sample.registerPostTaskHook(new TaskHook<>(2, str -> printMethod(str + " third2", 2)));

        sample.executePreTaskHooks("pre task");
        sample.executePostTaskHooks("post task");
    }

    private static void printMethod(String param, int order) {
        System.out.println("method=" + param + ", order=" + order);
    }

    private void registerPreTaskHook(TaskHook<String> hook) {
        preTaskHooks.add(hook);
        Collections.sort(preTaskHooks);
        Collections.reverse(preTaskHooks);
    }

    private void registerPostTaskHook(TaskHook<String> hook) {
        postTaskHooks.add(hook);
        Collections.sort(postTaskHooks);
    }

    private void executePreTaskHooks(String param) {
        executeHooks(preTaskHooks, param);
    }

    private void executePostTaskHooks(String param) {
        executeHooks(postTaskHooks, param);
    }

    private void executeHooks(List<TaskHook<String>> hooks, String param) {
        hooks.forEach(hook -> hook.getConsumer().accept(param));
    }
}
