package com.thread;

import java.security.interfaces.DSAKey;
import java.util.concurrent.TimeUnit;

public class effectiveJava {

	private static boolean flag ;
	
	public static synchronized boolean read(){
		return flag;
		
	}
	
	public static synchronized void change(){
		flag =true;
		
	}
	public static void main(String a[]) throws InterruptedException {
		
		Thread sd = new Thread( new Runnable() {
			public void run(){
				int i =0;
				while(!read()){
					System.out.println(i++);
					
				}
			}
		});
		sd.start();
		sd.join();
	//	TimeUnit.SECONDS.sleep(2);
		change();
	}
}
