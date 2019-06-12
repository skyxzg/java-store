package com.taobao.yiwei.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		// 创建一个可重用固定线程数的线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		MyRun1 r1 = new MyRun1();
		MyRun2 r2 = new MyRun2();
		
		// 将可执行代码放入线程池中执行
		for (int i = 0; i < 3; i++) {
			pool.execute(r1);
		}
		pool.execute(r2);
		
		// 关闭线程池
		pool.shutdown();
	}

}

class MyRun1 implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(tName + " 第" + (i+1) + "次执行Runnable1");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyRun2 implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.println(tName + " 第" + (i+1) + "次执行Runnable2");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
