package com.threadgroup;

public class MyThread extends Thread{
	
	//defining job of thraed is printing.
	String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MyThread(ThreadGroup g,String value) {
		super(g,value);
		this.value=value;
		//super();
		
	}
	
	public void run() {
		System.out.println(this.value);
	}

}
