package com.test;

import java.text.DecimalFormat;

import com.thread.interru;

public class testMain {
    
	public static void main(String a[]){
		/*new testMain(l);
		System.out.println(l);*/
		
		
		  
        //��ʾJVM���ڴ�  
        long totalMem = Runtime.getRuntime().totalMemory();  
        System.out.println(totalMem);  
        //��ʾJVM����ʹ�õ�����ڴ�  
        long maxMem = Runtime.getRuntime().maxMemory();  
        System.out.println(maxMem);  
        //�����ڴ�  
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
