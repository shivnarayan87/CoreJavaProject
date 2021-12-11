package com.util.callabledemo;

import java.util.concurrent.*;

public class CallableFutureDemo {
	
	public static void main(String[] args) throws Exception {
		ExecutorService service= Executors.newFixedThreadPool(3);
		MyCallable[] jobs= {new MyCallable(10),
							new MyCallable(20),
							new MyCallable(40),
							new MyCallable(60),
							new MyCallable(80),
							new MyCallable(100)};
		
		for(MyCallable job:jobs) {
			Future future = service.submit(job);
			Thread.sleep(5000);
			
			System.out.println(future.get());
			
		}
		service.shutdown();
	}

}

class MyCallable implements Callable{
	int number;
	
	
	
	public MyCallable(int number) {
		//super();
		this.number =number;
	}



	public Object call() throws Exception {
		int sum=0;
		System.out.println(Thread.currentThread().getName()+"  is responsible to calculate the"
				+ "  sum of first "+number+"  Numbers");
		for(int i=0;i<number;i++) {
			sum=sum+i;
			
		}
		return sum;
	}
	
}
