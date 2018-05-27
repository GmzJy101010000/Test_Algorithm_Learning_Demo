package com.test;

import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;

public  abstract class path {

	public path() {
		// TODO Auto-generated constructor stub
	}
   public static void main(String a[]){
	   /*String path="/global";
       int ds=path.lastIndexOf("/");
       System.out.println(ds);
       path=path.substring(0, ds);
       System.out.println(path);*/
	   Pattern f = Pattern.compile("pdf.*s$");
	   Matcher m= f.matcher("/test/sd.pdf_dfs");
	   while(m.find()){
		   System.out.println(m.group(0));
	   }
  // new Bb("test");
   }
   
   
}

class AA{
	
	public AA(String s){
		System.out.println(s);
	}
	public AA(String s,String t){
		this(s+t);
	}
	
	public AA(){
		this("1"+"2");
	}
}

class Bb extends AA{


	Bb(){
		super("4");
		
		
	}

	Bb(String a){
		System.out.println("test");
	}
	Bb(String s,String t){
	this(s+t+"3");	
	}
	 void sds(){}
}