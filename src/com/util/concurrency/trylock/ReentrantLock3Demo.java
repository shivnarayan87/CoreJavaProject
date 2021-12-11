package com.util.concurrency.trylock;

import java.util.concurrent.locks.ReentrantLock;
// this program is demo of trylock() method
public class ReentrantLock3Demo {
	public static void main(String[] args) {
		MyThread t= new MyThread("first thread");
		MyThread t1= new MyThread("Second thread");
		t.start();
		t1.start();
	}

}

class MyThread extends Thread{
	//i am creating multiple copy of mythread class but i want single copy of ReentrantLock instance
	static ReentrantLock l= new ReentrantLock();
	
	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		if(l.tryLock()) {
			System.out.println(Thread.currentThread().getName()+".. Got lock and perform safe operation");
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				l.unlock();
			}
		}else {
			System.out.println(Thread.currentThread().getName()+".. unable to get lock hence performing alternating operation.");
		}
	}
}
