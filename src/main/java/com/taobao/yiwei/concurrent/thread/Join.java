package com.taobao.yiwei.concurrent.thread;

public class Join {

	public static void main(String[] args) {
		JoinThread joinThread = new JoinThread();
		Thread t = new Thread(joinThread);
		t.start();
		
		String tName = Thread.currentThread().getName();
		for (int i = 1; i <= 10; i++) {
			if (i > 5) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(tName + "线程第" + i + "次执行。。。");
		}
	}
}

class JoinThread implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 1; i <= 10; i++) {
			System.out.println(tName + "线程第" + i + "次执行。。。");
		}
	}
}
