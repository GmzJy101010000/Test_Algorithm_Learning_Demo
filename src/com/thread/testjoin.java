package com.thread;

public class testjoin {
public static void main(String a[]){
	
	th t=new th();
	Thread t1=new Thread(t);
	t1.start();
	try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("我是主线程");
	for(int a1=10;a1<21;a1++){
		System.out.println(a1);
	}
	
}
	
	
}
class th implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int s = 0;s<10;s++){
			System.out.println(s);
		}
	}
	
}