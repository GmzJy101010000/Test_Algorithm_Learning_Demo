package com.test;




public class testEx {

	public testEx() {
		// TODO Auto-generated constructor stub
	}
   
	public static void main(String[] args) {
		int a=-1;
		//new testEx().test0();
		assert a>0;
	}
	
	boolean test0(){
		boolean ret =true;
		try {
			ret = test1();
		} catch (Exception e) {
			System.out.println("test 0 ,catch exception!!");
			ret =false;
			throw e;
		}finally{
			System.out.println("test 0 finally");
		}
		return ret;
	}

	 @SuppressWarnings("finally")
	boolean test1() {
		 boolean ret =true;
			try {
				ret = test2();
				if(!ret){
					return false;
				}
				System.out.println("at the end of test 1 try");
			} catch (Exception e) {
				System.out.println("test 1 ,catch exception!!");
				ret =false;
				
				throw e;
				
			}finally{
				System.out.println("test 1 finally");
				return ret;
			}
			
			
	}

	@SuppressWarnings("finally")
	private boolean test2() {
		boolean ret =true;
		try {
			int b=12;
			int c;
			for(int i=2;i>=-2;i--){
				c=b/i;
				System.out.println("i=" + i);
				
			}
			return true;
		} catch (Exception e) {
			System.out.println("test 2 ,catch exception!!");
			ret =false;
			throw e;
		}finally{
			System.out.println("test 2 finally");
			return ret;
		}
		
	}
}


class A{
	void myfun() throws ArithmeticException,InterruptedException{
		div();
	}
	void div() throws ArithmeticException{
		
	}
}
class b extends A{
	void myfun(boolean boo){
		assert boo?true:false;
	}
}
