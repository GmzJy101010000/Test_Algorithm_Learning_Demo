package com.test;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.security.auth.x500.X500Principal;

import com.thread.interru;

public class var {
	
 
	public var() {
		// TODO Auto-generated constructor stub
		
	}
 static int a;
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		asd a1=new asd();
		int aa=0;
		int bb=a1.change(aa);
		System.out.println(aa+" "+bb);
		/*int [] cc=new int[]{1,2,3};
		a1.changeArray(cc);
		for(int j=0;j<cc.length;j++){
		System.out.println(cc[j]);	
		}*/
		StringBuffer as=new StringBuffer("uk");
		StringBuffer bs=a1.changeString(as);
		System.out.println(as+"  "+bs);
		mifi(a);
		System.out.println(a);
		}
    public static void mifi(int a){
    	a++;
    }
}
class asd{
	private   int i;

	public asd(){
		i++;
	}
	public  int getI() {
		return this.i;
	}

	public  void setI(int i) {
		this.i = i;
	}
	
	public int change(int a){
		a=6;
		return a;
	}
	
	public int[] changeArray(int[] aa){
		for(int a=0;a<aa.length;a++){
			aa[a]++;
		}
		return aa;	
	}
	
	public StringBuffer changeString(StringBuffer as){
		
			System.out.println(2);
			as.append("gb");
		return as;
	}
}

