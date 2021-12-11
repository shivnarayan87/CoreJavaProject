package com.countdownlatchdemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo implements Runnable {
	CyclicBarrier barrier;
	
	
	public CyclicBarrierDemo(CyclicBarrier barrier) {
		this.barrier = barrier;
	}


	public void run() {
		//while (true) {
			try {
				barrier.await();
				System.out.println("send sms");
			} catch (Exception e) {
			}
			
	//	}
	
		// send sms to all players
		
	}
	
	public static void main(String[] args)throws InterruptedException {
		ExecutorService service =Executors.newFixedThreadPool(4);
		CyclicBarrier cb= new CyclicBarrier(3);
		service.submit(new CyclicBarrierDemo(cb));
		service.submit(new CyclicBarrierDemo(cb));
		service.submit(new CyclicBarrierDemo(cb));
		
		Thread.sleep(2000);
	}

}
