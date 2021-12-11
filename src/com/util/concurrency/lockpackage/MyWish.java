package com.util.concurrency.lockpackage;

public class MyWish extends Thread{
	Display d;
	String name;
	public MyWish(Display d, String name) {
		//super();
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
	

}
