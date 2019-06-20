package com.taobao.yiwei.java8;

import lombok.Data;

import java.util.*;
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
                return new Transaction(1000 + index++, TransactionType.get(index % 3), random.nextInt(100));
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
