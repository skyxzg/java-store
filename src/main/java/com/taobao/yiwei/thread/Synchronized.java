package com.taobao.yiwei.thread;

public class Synchronized {

	public static void main(String[] args) {
		User user = new User("Kevin", 100);
		OperThread t1 = new OperThread("线程1", user, 20);
		OperThread t2 = new OperThread("线程2", user, -60);
		OperThread t3 = new OperThread("线程3", user, -80);
		OperThread t4 = new OperThread("线程4", user, -30);
		OperThread t5 = new OperThread("线程5", user, 32);
		OperThread t6 = new OperThread("线程6", user, 21);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

}

class OperThread extends Thread {
	private User user;
	private int money;
	
	public OperThread(String name, User user, int money) {
		super(name);
		this.user = user;
		this.money = money;
	}
	
	public void run() {
		user.operate(money);
	}
}

class User {
	private String code;
	private int balance;
	
	public User(String code, int balance) {
		this.code = code;
		this.balance = balance;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	// 同步方法
//	public synchronized void operate(int money) {
//		String tName = Thread.currentThread().getName();
//		this.balance += money;
//		System.out.println(tName + "运行结束，增加" + money + "，当前用户账户余额为：" + this.balance);
//	}
	
	// 同步代码块
	public void operate(int money) {
		String tName = Thread.currentThread().getName();
		synchronized(this) {
			this.balance += money;
		System.out.println(tName + "运行结束，增加" + money + "，当前用户账户余额为：" + this.balance);
		}
	}
}
