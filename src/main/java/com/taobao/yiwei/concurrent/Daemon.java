package com.taobao.yiwei.concurrent;

public class Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyDaemon());
		Thread t2 = new Thread(new MyCommon());
		Thread t3 = new Thread(new MyCommon());
		t1.setDaemon(true);      // 设置为守护线程
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class MyDaemon implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 9999999L; i++) {
			System.out.println(tName + " 守护线程第" + i + "次执行。。。");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyCommon implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 5; i++) {
			System.out.println(tName + " 用户线程第" + i + "次执行。。。");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}