package com.test;

import java.text.DecimalFormat;

import com.thread.interru;

public class testMain {
    
	public static void main(String a[]){
		/*new testMain(l);
		System.out.println(l);*/
		
		
		  
        //显示JVM总内存  
        long totalMem = Runtime.getRuntime().totalMemory();  
        System.out.println(totalMem);  
        //显示JVM尝试使用的最大内存  
        long maxMem = Runtime.getRuntime().maxMemory();  
        System.out.println(maxMem);  
        //空闲内存  
        long freeMem = Runtime.getRuntime().freeMemory();  
        System.out.println(freeMem);  
		 
	}
	static int i=5;
	 static int l;
	int j=7;
	int k;
	
	public testMain(int m){
		
		{String i = null ;}
		if(true){
			String i ="";
		}
	
		
		System.out.println(i+" "+j+" "+k+" "+l+" "+m);
	}
	{
		j=70;
		l=20;
		
	}
	static {
		//l=900;
		i=50;
	}
}
