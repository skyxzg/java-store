package com.taobao.yiwei.java8;

import lombok.Data;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {
    public static void main(String[] args) {
        StreamSample streamSample = new StreamSample();

        // 准备数据
//        List<Transaction> dataList = buildDataList(15);     // 普通方式
        List<Transaction> dataList = supplyDataList(15);     // Supplier方式

        // Java8之前处理方式
        streamSample.normalProcess(dataList);

        // Stream 处理方式
        streamSample.streamProcess(dataList);

        // ParallelStream 处理方式
        streamSample.parallelStreamProcess(dataList);
    }

    private static List<Transaction> buildDataList(int num) {
        System.out.println("======== 普通方式准备数据 begin ========");
        List<Transaction> groceryTransactions = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            Transaction t = new Transaction(1000 + i, TransactionType.get(i%3), rand.nextInt(100));
            groceryTransactions.add(t);
            System.out.println(t.toString());
        }

        System.out.println("======== 普通方式准备数据 end ========");

        return groceryTransactions;
    }

    private static List<Transaction> supplyDataList(int num) {
        System.out.println("======== Supplier方式准备数据 begin ========");

        Supplier<Transaction> supplier = new Supplier<Transaction>() {
            private int index = 0;
            private Random random = new Random();

            @Override
            public Transaction get() {
                return new Transaction(1000 + index, TransactionType.get(index++ % 3), random.nextInt(100));
            }
        };

        List<Transaction> dataList = Stream.generate(supplier).limit(num).collect(Collectors.toList());
        dataList.forEach(System.out::println);

        System.out.println("======== Supplier方式准备数据 end ========");
        return dataList;
    }


    private void normalProcess(List<Transaction> transactions) {
        System.out.println("======== Java8之前处理方式 begin ========");

        List<Transaction> groceryTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.GROCERY) {
                groceryTransactions.add(t);
            }
        }

        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });

        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : groceryTransactions) {
            transactionIds.add(t.getId());
        }

        for (Integer i : transactionIds) {
            System.out.println(i);
        }
        System.out.println("======== Java8之前处理方式 end ========");
    }

    private void streamProcess(List<Transaction> transactions) {
        System.out.println("======== Stream 处理方式 begin ========");

        List<Integer> transactionIds = transactions.stream()
                .filter(t -> t.getType() == TransactionType.GROCERY)
//                .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))     // lambda
                .sorted(Comparator.comparing(Transaction::getValue).reversed())     // method reference
//                .map(t -> t.getId())     // lambda
                .map(Transaction::getId)     // method reference
                .collect(Collectors.toList());

        transactionIds.forEach(System.out::println);

        System.out.println("======== Stream 处理方式 end ========");
    }

    /**
     * 1. 在大数据量输入的时候，parallel streams可以带来比较大的性能提升。但是应该记住，一些并行操作，
     *    比如：reduce，collect需要额外的计算（组合操作），但是在顺序流中，这些组合操作是不需要的。
     * 2. 另外，我们知道所有的parallel stream操作共享一个jvm范围内的ForkJoinPool，所以你应该注意避免在parallel stream上
     *    执行慢阻塞流操作，因为这些操作可能导致你应用中依赖parallel streams操作的其他部分也会响应变慢。
     * @param transactions
     */
    private void parallelStreamProcess(List<Transaction> transactions) {
        System.out.println("======== ParallelStream 处理方式 begin ========");

        // 查默认并行度
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("默认并行度：" + commonPool.getParallelism());    // 3

        List<Integer> transactionIds = transactions.parallelStream()
                .filter(t -> {
                    System.out.format("filter: %s [%s]\n", t.getId(), Thread.currentThread().getName());
                    return t.getType() == TransactionType.GROCERY;
                })
                .peek(t -> {
                    // 增加一层peek，观察并行的特点
                    System.out.format("peek: %s [%s]\n", t.getId(), Thread.currentThread().getName());
                })
                .sorted((t1, t2) -> {
                    // sort是有状态操作：元素的处理受前面元素的影响，有状态的中间操作必须等到所有元素处理之后才知道最终结果: 需要当前元素，额外的状态
                    // 从结果中可以看到sort是由main线程来完成。
                    // parallel stream中的sort操作使用了JAVA 8的一个新方法：Arrays.parallelSort()。
                    // JAVA doc中是这样描述Arrays.parallelSort()的：待排序数组的长度决定了排序操作是顺序执行还是并行执行。
                    System.out.format("sorted: %s <> %s [%s]\n", t1.getId(), t2.getId(), Thread.currentThread().getName());
                    return t2.getValue().compareTo(t1.getValue());
                })
                .map(t -> {
                    System.out.format("map: %s [%s]\n", t.getId(), Thread.currentThread().getName());
                    return t.getId();
                })
                .collect(Collectors.toList());

        transactionIds.forEach(System.out::println);

        System.out.println("======== ParallelStream 处理方式 end ========");

    }
}


@Data
class Transaction {
    private Integer id;
    private TransactionType type;
    private Integer value;

    public Transaction(Integer id, TransactionType type, Integer value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return id + " " + type + " " + value;
    }
}

enum TransactionType {
    GROCERY(0),
    CAR(1),
    HOUSE(2);

    private int index;

    private TransactionType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static TransactionType get(int index) {
        for (TransactionType t : TransactionType.values()) {
            if (index == t.getIndex()) {
                return t;
            }
        }
        return null;
    }
}
