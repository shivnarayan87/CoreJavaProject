package com.util.executordemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// 3 threads are responsible to execute 6 jobs, single thread reused for multiple job.this possible 
// by executor framework
public class ExecutorDemo {
	public static void main(String[] args) {
		PrintJob[] jobs= {new PrintJob("shiv"),
				new PrintJob("priya"),
				new PrintJob("ishu"),
				new PrintJob("rv"),
				new PrintJob("jaysi"),
				new PrintJob("gudiya")} ;
		
		ExecutorService service= Executors.newFixedThreadPool(3);
		for(PrintJob job:jobs) {
			service.submit(job);
		}
		service.shutdown();
		
	}

}

class PrintJob implements Runnable{
	String name;
	public PrintJob(String name) {
		this.name=name;
	}
	public void run() {
		System.out.println(name+"..Job started by Thread"+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println(name+"..Job completed by Thread"+Thread.currentThread().getName());
		
	}
	
}
