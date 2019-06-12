package com.taobao.yiwei.concurrent.thread;

public class ExtendsThread {

	public static void main(String[] args){
		Thread t = new MyThread2("Demo Thread");
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main concurrent:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 extends Thread {
	
	public MyThread2(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child concurrent:" + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
