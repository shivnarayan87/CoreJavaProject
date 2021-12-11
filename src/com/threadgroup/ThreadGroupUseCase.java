package com.threadgroup;
// we are adding several thread into new created threadgroup.
public class ThreadGroupUseCase {
	public static void main(String[] args) {
		ThreadGroup g= new ThreadGroup("printing threads");
		MyThread t= new MyThread(g, "header printing");
		MyThread t1= new MyThread(g, "body printing");
	
		g.setMaxPriority(1);
		MyThread t2= new MyThread(g, "footer printing");
		
		System.out.println(g.getMaxPriority());//we can add thread into thread group ,
		//which priotity upto max 10
		System.out.println(g.getName());// name of thread group
		System.out.println(t.getPriority());
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		g.list();
		System.out.println(g.activeCount());
		System.out.println(g.activeGroupCount());
		t2.start();
		t.start();
		t1.start();
	
		
		
	}
	

}
