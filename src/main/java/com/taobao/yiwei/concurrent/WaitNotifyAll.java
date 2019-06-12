package com.taobao.yiwei.concurrent;

public class WaitNotifyAll {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		ReaderResult readResult1 = new ReaderResult(calculator);
		ReaderResult readResult2 = new ReaderResult(calculator);
		ReaderResult readResult3 = new ReaderResult(calculator);
		
		//启动3个读取线程
		readResult1.start();
		readResult2.start();
		readResult3.start();
		
		//保证计算线程晚于读取线程启动
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//启动计算线程
		calculator.start();
	}

}

/**
 * 获取结果并输出
 * @author zhigang.xzg
 */
class ReaderResult extends Thread {
	Calculator c;
	
	public ReaderResult(Calculator c) {
		this.c = c;
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized (c) {
			System.out.println(threadName + "等待计算结果。。。");
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + "计算结果为：" + c.total);
		}
	}
}

/**
 * 计算线程
 * @author zhigang.xzg
 */
class Calculator extends Thread {
	int total;
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized(this) {
			System.out.println(threadName + "计算线程获得锁。。。");
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			//通知所有在此对象上等待的线程
			notifyAll();
			System.out.println(threadName + "计算线程释放锁。。。");
		}
	}
}
