package com.util.concurrency.lockpackage;
import java.util.concurrent.locks.*;

//in this application we are to explore different method of ReentrantLock class
public class ReentrantLock2 {
	public static void main(String[] args) {
		ReentrantLock l= new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println(l.isLocked()); //true
		System.out.println(l.isHeldByCurrentThread()); //true
		System.out.println(l.getHoldCount()); //2
		System.out.println(l.getQueueLength());//0 no other thread waiting.
		l.unlock();
		System.out.println(l.getHoldCount());// decreas hold count by 1 value
		System.out.println(l.isLocked());//true
		l.unlock();
		System.out.println(l.getHoldCount());//0
		System.out.println(l.isLocked());// false means current thread release the lock
		System.out.println(l.isHeldByCurrentThread());
		System.out.println(l.isFair());// false
		
		
		
	}

}
