package com.util.concurrency.lockpackage;

import java.util.concurrent.locks.ReentrantLock;
// use of lock() and unlock() method
public class Display {
	ReentrantLock l= new ReentrantLock();
	// if we comment line 1 ane line 2 we will get irregular output.
	// otherwise  thread will executed one by one and get regular out
	//
	public  void wish(String name) {
		l.lock(); //line
		
		for(int i=0;i<10;i++) {
			System.out.print("good morning:");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println(name);
			
		}
		l.unlock();// line2
		
	}

}
