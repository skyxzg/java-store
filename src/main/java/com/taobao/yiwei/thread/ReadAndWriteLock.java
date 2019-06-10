package com.taobao.yiwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadAndWriteLock {

	public static void main(String[] args) {
		// 创建并发访问的账户
		CreditCardAccount2 account = new CreditCardAccount2("95599200901215522", 10000);
		
		// 创建锁对象
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 创建并发访问任务
		ConsumeRefundTask2 task1 = new ConsumeRefundTask2("Kevin", account, -4000, lock, false);
		ConsumeRefundTask2 task2 = new ConsumeRefundTask2("Jim", account, 6000, lock, false);
		ConsumeRefundTask2 task3 = new ConsumeRefundTask2("Lucy", account, 800, lock, true);
		ConsumeRefundTask2 task4 = new ConsumeRefundTask2("Phebe", account, -8000, lock, false);
		ConsumeRefundTask2 task5 = new ConsumeRefundTask2("Jack", account, -1500, lock, false);
		
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

class ConsumeRefundTask2 implements Runnable {
	private String name;
	private CreditCardAccount2 account;
	private int monney;
	private ReadWriteLock lock;
	private boolean isCheck;
	
	public ConsumeRefundTask2(String name, CreditCardAccount2 account, int monney, ReadWriteLock lock, boolean isCheck) {
		this.name = name;
		this.account = account;
		this.monney = monney;
		this.lock = lock;
		this.isCheck = isCheck;
	}
	
	public void run() {
		String tName = Thread.currentThread().getName();
		if (isCheck) {
			// 获取读锁
			lock.readLock().lock();
			
			System.out.println(tName + " 读：" + name + "正在查询，账户为" + account + "，当前余额为" + account.getBalance());
			
			// 释放读锁
			lock.readLock().unlock();
		} else {
			// 获取写锁
			lock.writeLock().lock();
			
			// 执行现金业务
			System.out.println(tName + " 写：" + name + "正在操作，账户为" + account + "，金额为" + monney + "，当前余额为" + account.getBalance());
			account.operate(monney);
			System.out.println(tName + " 写：" + name + "操作成功，账户为" + account + "，金额为" + monney + "，当前余额为" + account.getBalance());
			
			// 释放写锁
			lock.writeLock().unlock();
		}
	}
}

class CreditCardAccount2 {
	private String cid;  // 账号
	private int balance; // 余额
	
	public CreditCardAccount2(String cid, int balance) {
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



