package com.threadgroup;

public class ThreadGroupDetails {
	
	public static void main(String[] args) {
		
		// main thread group and its parrent thread group system
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
	} 
	

}
