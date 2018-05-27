package com.thread;

public class interru {
  public  static  void  main(String a[]) throws InterruptedException{
	  System.out.println("starting....");
	  ss s=new ss();
	  Thread th=new  Thread(s);
	  th.start();
	  Thread.sleep(10000);
	  th.interrupt();
	  s.ah=false;
	  System.out.println("game over!!");
  }
	
	
}
class ss implements Runnable{
   static int  i;
   volatile boolean ah=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ah){
			 i=1;
			System.out.println("is running!!");
			long time=System.currentTimeMillis();
			while(System.currentTimeMillis()-time<3000){
				
			}
		}
	}
	
}