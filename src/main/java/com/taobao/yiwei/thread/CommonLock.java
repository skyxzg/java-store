package com.taobao.yiwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CommonLock {

	public static void main(String[] args) {
		// 创建并发访问的账户
		CreditCardAccount2 account = new CreditCardAccount2("95599200901215522", 10000);
		
		// 创建锁对象
		Lock lock = new ReentrantLock();
		
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 创建并发访问任务
		ConsumeRefundTask task1 = new ConsumeRefundTask("Kevin", account, -4000, lock);
		ConsumeRefundTask task2 = new ConsumeRefundTask("Jim", account, 6000, lock);
		ConsumeRefundTask task3 = new ConsumeRefundTask("Lucy", account, 800, lock);
		ConsumeRefundTask task4 = new ConsumeRefundTask("Phebe", account, -8000, lock);
		ConsumeRefundTask task5 = new ConsumeRefundTask("Jack", account, -1500, lock);
		
		// 将任务加入到线程池
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.execute(task5);
		
		// 关闭线程池
		pool.shutdown();
	}

}

class ConsumeRefundTask implements Runnable {
	private String name;
	private CreditCardAccount2 account;
	private int monney;
	private Lock lock;
	
	public ConsumeRefundTask(String name, CreditCardAccount2 account, int monney, Lock lock) {
		this.name = name;
		this.account = account;
		this.monney = monney;
		this.lock = lock;
	}
	
	public void run() {
		// 获取锁
		lock.lock();
		
		// 执行现金业务
		System.out.println(name + "正在操作" + account + "账户，金额为" + monney + "，当前余额为" + account.getBalance());
		account.operate(monney);
		System.out.println(name + "操作" + account + "账户成功，金额为" + monney + "，当前余额为" + account.getBalance());
		
		// 释放锁
		lock.unlock();
	}
}

class CreditCardAccount {
	private String cid;  // 账号
	private int balance; // 余额
	
	public CreditCardAccount(String cid, int balance) {
		this.cid = cid;
		this.balance = balance;
	}
	
	public String getCid() {
		return this.cid;
	}
	
	public int getBalance() {
		return this.balance; 
	}
	
	public void operate(int monney) {
		this.balance += monney;
	}
	
	@Override
	public String toString() {
		return "AccountInfo:{cid=" + this.cid + ",balance=" + this.balance + "}";
	}
}



