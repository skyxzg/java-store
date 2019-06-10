package com.taobao.yiwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadAndWriteLockDemo {


	public static void main(String[] args) {
		UserAccount account = new UserAccount("95599200901215522", 10000, 0);
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		ExecutorService pool = Executors.newFixedThreadPool(10);

		AccountFlushTask daemonTask = new AccountFlushTask(account, 2, lock);
		AccountWriteTask writeTask1 = new AccountWriteTask(account, 1, 9, lock);
		AccountWriteTask writeTask2 = new AccountWriteTask(account, 10, 8, lock);
		AccountWriteTask writeTask3 = new AccountWriteTask(account, 100, 7, lock);
		AccountReadTask readTask1 = new AccountReadTask(account, 10, lock);
		AccountReadTask readTask2 = new AccountReadTask(account, 10, lock);
		
		Thread daemonThread = new Thread(daemonTask);
		daemonThread.setDaemon(true); 
		daemonThread.start();
		
		pool.execute(writeTask1);
		pool.execute(writeTask2);
		pool.execute(writeTask3);
		pool.execute(readTask1);
		pool.execute(readTask2);
		
		pool.shutdown();
	}
}


class AccountFlushTask implements Runnable {
	private UserAccount account;
	private int flushPeriod;
	private ReadWriteLock lock;

	public AccountFlushTask(UserAccount account, int flushPeriod, ReadWriteLock lock) {
		this.account = account;
		this.flushPeriod = flushPeriod;
		this.lock = lock;
	}
	
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 1; i < Long.MAX_VALUE; i++) {
			System.out.println(tName + " 守护线程第" + i + "次刷新缓存，开始。。。");
			// 此处省略操作：从数据库中读取业务表，取其中一行
			lock.writeLock().lock();
			account.setAccountId("95599200901215522");
			account.setBalance(10000);
			account.setLastTransaction(0);
			lock.writeLock().unlock();
			System.out.println(tName + " 守护线程第" + i + "次刷新缓存，完成");
			try {
				Thread.sleep(flushPeriod*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class AccountReadTask implements Runnable {
	private UserAccount account;
	private int times;
	private ReadWriteLock lock;
	
	public AccountReadTask(UserAccount account, int times, ReadWriteLock lock) {
		this.account = account;
		this.times = times;
		this.lock = lock;
	}
	
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < times; i++) {
			lock.readLock().lock();
			System.out.println(tName + " 第" + (i+1) + "次查询，账户" + account.getaccountId() + "，交易额" + account.getLastTransaction() + "，余额" + account.getBalance());
			lock.readLock().unlock();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class AccountWriteTask implements Runnable {
	private UserAccount account;
	private int monney;
	private int times;
	private ReadWriteLock lock;
	
	public AccountWriteTask(UserAccount account, int monney, int times, ReadWriteLock lock) {
		this.account = account;
		this.monney = monney;
		this.times = times;
		this.lock = lock;
	}
	
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < times; i++) {
			lock.writeLock().lock();
			System.out.println(tName + " 第" + (i+1) + "次开始写，账户" + account.getaccountId() + "，交易额" + monney + "，余额" + account.getBalance());
			account.operate(monney);
			System.out.println(tName + " 第" + (i+1) + "次写成功，账户" + account.getaccountId() + "，交易额" + monney + "，余额" + account.getBalance());
			lock.writeLock().unlock();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class UserAccount {
	private String accountId;  // 账号
	private int balance; // 余额
	private int lastTransaction; // 最后一笔交易额
	
	public UserAccount(String accountId, int balance, int lastTransaction) {
		this.accountId = accountId;
		this.balance = balance;
		this.lastTransaction = lastTransaction;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getaccountId() {
		return this.accountId;
	}
	
	public void setBalance(int balance) {
		this.balance = balance; 
	}
	
	public int getBalance() {
		return this.balance; 
	}
	
	public void setLastTransaction(int lastTransaction) {
		this.lastTransaction = lastTransaction; 
	}
	
	public int getLastTransaction() {
		return this.lastTransaction; 
	}
	
	public void operate(int monney) {
		this.balance += monney;
		this.lastTransaction = monney;
	}
	
	@Override
	public String toString() {
		return "AccountInfo:{accountId=" + this.accountId + ",balance=" + this.balance + ",lastTransaction=" + lastTransaction + "}";
	}
}



