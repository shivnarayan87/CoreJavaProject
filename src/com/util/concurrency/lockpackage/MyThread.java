package com.util.concurrency.lockpackage;

public class MyThread {
	public static void main(String[] args) {
		Display d= new Display();
		MyWish t= new MyWish(d,"dhoni");
		MyWish t1= new MyWish(d,"yuvraj");
		MyWish t2= new MyWish(d,"kohli");
		t.start();
		t1.start();
		t2.start();
	}

}
