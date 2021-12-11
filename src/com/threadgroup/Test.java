package com.threadgroup;

//to create our own thread group
public class Test {
	public static void main(String[] args) {
		ThreadGroup g= new ThreadGroup("firstgroup");
		System.out.println(g.getName());
		System.out.println(g.getParent().getName());
		
		//secondgroup  thread group is child of firstthread  group.
		ThreadGroup g1= new ThreadGroup(g,"secondgroup");
		System.out.println(g1.getName());
		System.out.println(g1.getParent().getName());
	}

}
