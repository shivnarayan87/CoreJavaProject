package com.countdownlatchdemo;

import java.util.concurrent.*;

//demo of count down latch. use case is main service/main thread wait until dependent service
// perform initialization.

public class DependentService implements Runnable {
	
	private CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
	
		this.latch = latch;
	}

	public void run() {
		// perform some databbase initialization
		System.out.println("dependent services perform initilization");
		latch.countDown();
		System.out.println(latch.getCount());
		// thread will do other task also here
		
	}
	
	public static void main(String[] args)throws InterruptedException {
		
		ExecutorService service=Executors.newFixedThreadPool(4);
		
		CountDownLatch countlatch= new CountDownLatch(3);
		System.out.println("main thread has to wait until dependent services complete initialize");
		service.submit(new DependentService(countlatch));
		service.submit(new DependentService(countlatch));
		service.submit(new DependentService(countlatch));
		
		// three dependent services initializing then main thread has to wait
		
		countlatch.await();
		
		// main service start and perform initialization.
		System.out.println("main thread start and perform initilization");
		
	}
	
	

}
