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
		System.out.println("��̬��������1");
	}
	{System.out.println("��������1");}
	int i;
	static {
		System.out.println("��̬��������2");
	}
	{System.out.println("��������2");}
	public static void me(){
		System.out.println("��̬����");
	}
	public apple(){
		System.out.println("���췽��");
	}
	{System.out.println("��������3");}
}

class subapple extends apple{
	static {
		System.out.println("���ྲ̬��������1");
	}
	{System.out.println("������������1");}
	int i;
	static {
		System.out.println("���ྲ̬��������2");
	}
	{System.out.println("������������2");}
	public static void me(){
		System.out.println("���ྲ̬����");
	}
	public subapple() {
		System.out.println("���๹�췽��");
		try {
			throw new Exception();
		} catch (Exception e) {
			throw e;
		}
		finally{
			
			return ;
		}
	}
	{System.out.println("������������3");}
	

}
