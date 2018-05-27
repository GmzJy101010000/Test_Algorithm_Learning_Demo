package com.test;



public class testConstror {

	public testConstror() {
		// TODO Auto-generated constructor stub
	}
   public static void main(String[] args)  {
	new subapple();
}
}

class apple{
	
	static {
		System.out.println("静态游离代码块1");
	}
	{System.out.println("游离代码块1");}
	int i;
	static {
		System.out.println("静态游离代码块2");
	}
	{System.out.println("游离代码块2");}
	public static void me(){
		System.out.println("静态方法");
	}
	public apple(){
		System.out.println("构造方法");
	}
	{System.out.println("游离代码块3");}
}

class subapple extends apple{
	static {
		System.out.println("子类静态游离代码块1");
	}
	{System.out.println("子类游离代码块1");}
	int i;
	static {
		System.out.println("子类静态游离代码块2");
	}
	{System.out.println("子类游离代码块2");}
	public static void me(){
		System.out.println("子类静态方法");
	}
	public subapple() {
		System.out.println("子类构造方法");
		try {
			throw new Exception();
		} catch (Exception e) {
			throw e;
		}
		finally{
			
			return ;
		}
	}
	{System.out.println("子类游离代码块3");}
	

}
