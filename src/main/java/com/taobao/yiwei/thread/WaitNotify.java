package com.taobao.yiwei.thread;

public class WaitNotify {

	public static void main(String[] args) {
		ComputeThread t = new ComputeThread();
		
		//主线程获取compute对象上的锁。为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者。
		synchronized (t) {
			t.start();
			try {
				System.out.println("等待对象compute完成计算。。。");
				/*在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
				    当前线程必须拥有此对象监视器才能调用wait方法。当在对象上调用wait()方法时，执
				    行该代码的线程立即放弃它在对象上的锁。一直等待直到其他线程通过调用 notify方法，
				    或notifyAll 方法通知在此对象的监视器上等待的线程醒来。然后该线程将等到重新获
				    得对监视器的所有权后才能继续执行。 */
				t.wait(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("compute对象计算的总和是：" + t.total);
		}
	}
}

class ComputeThread extends Thread {
	public int total;
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized (this) {
			System.out.println(threadName + "子进程获得锁。。。");
			for (int i = 0; i < 101; i++) {
				total += i;
				try {
					Thread.sleep(20); //线程休眠（暂停执行），该线程不丢失任何监视器的所属权。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//（完成计算了）唤醒在此对象监视器上等待的单个线程
			//如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。
			//选择是任意性的，并在对实现做出决定时发生。
			notify();
			System.out.println(threadName + "子进程释放锁。。。");
		}
	}
}
