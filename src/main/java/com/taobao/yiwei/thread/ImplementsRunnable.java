package com.taobao.yiwei.thread;

public class ImplementsRunnable {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread(), "Demo Thread");
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread  implements Runnable {
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child thread:" + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
