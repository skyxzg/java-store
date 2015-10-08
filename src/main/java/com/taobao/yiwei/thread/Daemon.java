package com.taobao.yiwei.thread;

public class Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyCommon());
		Thread t2 = new Thread(new MyDaemon());
		t2.setDaemon(true);      // 设置为守护线程
		
		t1.start();
		t2.start();
	}

}

class MyDaemon implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 9999999L; i++) {
			System.out.println(tName + "后台线程第" + i + "次执行。。。");
		}
	}
}

class MyCommon implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 5; i++) {
			System.out.println(tName + "线程第" + i + "次执行。。。");
		}
	}
}