package com.taobao.yiwei.collection.list;

import java.util.function.Consumer;

public class TaskHook<T> implements Comparable<TaskHook<T>> {

    private Integer order;
    private Consumer<T> consumer;

    public TaskHook(Integer order, Consumer<T> consumer) {
        this.order = order;
        this.consumer = consumer;
    }

    public Integer getOrder() {
        return this.order;
    }

    public Consumer<T> getConsumer() {
        return this.consumer;
    }

    @Override
    public int compareTo(TaskHook<T> h) {
        return this.getOrder().compareTo(h.getOrder());
    }
}
