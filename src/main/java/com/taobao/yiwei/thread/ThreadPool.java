package com.taobao.yiwei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		// 创建一个可重用固定线程数的线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		// 将线程放入池中执行
		for (int i = 0; i < 10; i++) {
			pool.execute(t1);
		}
		pool.execute(t2);
		
		// 关闭线程池
		pool.shutdown();
	}

}

class Thread1 implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		System.out.println(tName + "执行Runnable1");
	}
}

class Thread2 implements Runnable {
	public void run() {
		String tName = Thread.currentThread().getName();
		System.out.println(tName + "执行Runnable2");
	}
}
