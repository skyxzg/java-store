package com.taobao.yiwei.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ImplementsCallable {

	public static void main(String[] args) {
		ArrayList<Future<String>> futureList = new ArrayList<Future<String>>();
		
		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 创建有返回值的任务并执行
		for (int i = 0; i < 10; i++) {
			MyCallable task = new MyCallable("task"+i);
			futureList.add(pool.submit(task));
		}
		
		// 获取任务返回值
		for (Future<String> future : futureList) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		// 关闭线程池
		pool.shutdown();
	}

}

class MyCallable implements Callable<String> {
	private String str;
	
	public MyCallable(String str) {
		this.str = str;
	}
	
	public String call() {
		return str + " return!";
	}
}
