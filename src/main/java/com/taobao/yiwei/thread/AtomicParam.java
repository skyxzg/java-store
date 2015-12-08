package com.taobao.yiwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicParam {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Lock lock = new ReentrantLock();
		SaveTask t1 = new SaveTask("Frank", 1000, lock);
		SaveTask t2 = new SaveTask("Lily", 800, lock);
		SaveTask t3 = new SaveTask("Tom", 2100, lock);
		SaveTask t4 = new SaveTask("Kevin", 1500, lock);
		SaveTask t5 = new SaveTask("Lucy", 3000, lock);
		SaveTask t6 = new SaveTask("Jack", 500, lock);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.shutdown();
	}
}

class SaveTask implements Runnable {
	/***
	 * 所谓的原子量即操作变量的操作是“原子的”，该操作不可再分，因此是线程安全的。
	 * 但是原子量虽然可以保证单个变量在某一个操作过程的安全，但无法保证你整个代码块，
	 * 或者整个程序的安全性。因此，通常还应该使用锁等同步机制来控制整个程序的安全性。
	 */
	private static AtomicLong balance = new AtomicLong(0);
//	private static int balance = 0;
	private String name;
	private int money;
	private Lock lock;
	
	public SaveTask(String name, int money, Lock lock) {
		this.name = name;
		this.money = money;
		this.lock = lock; 
	}
	
	public void run() {
		lock.lock();
		balance.addAndGet(this.money);
		System.out.println(name + "存入了" + money + "，当前余额为：" + balance.get());
//		this.balance += this.money;
//		System.out.println(name + "存入了" + money + "，当前余额为：" + this.balance);
		lock.unlock();
	}
}

