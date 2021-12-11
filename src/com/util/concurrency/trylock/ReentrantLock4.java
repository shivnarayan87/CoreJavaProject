package com.util.concurrency.trylock;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// in this application try to explain trylock method with time parameter.
public class ReentrantLock4 {
	public static void main(String[] args) {
		
		MyThreadDemo t= new MyThreadDemo("firstthread:");
		MyThreadDemo t1= new MyThreadDemo("Secondthread:");
		MyThreadDemo t2= new MyThreadDemo("Thirdthread:");
		t.start();
		t1.start();
		t2.start();
		
	}
	

}
class MyThreadDemo extends Thread{
	static ReentrantLock l= new ReentrantLock(true);
	
	public MyThreadDemo(String name) {
		super(name);
	}
	public void run() {
		do {
			
			try {
				if (l.tryLock(5000,TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName()+" ..Got the lock and perfrom safe operation.");
					Thread.sleep(30000);
					l.unlock();
					break;
					
					
				} else {
					System.out.println(Thread.currentThread().getName()+" ..not got lock hence perform alternative operation.");
					

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		} while (true);
		
		
	}
	
}
