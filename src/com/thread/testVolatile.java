package com.thread;

public class testVolatile {
    public  int inc = 0;
 
    public synchronized void increase() {
        inc++;
    }
 
    public static void main(String[] args) {
  
        final testVolatile test = new testVolatile();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                    {       test.increase();
                  //  System.out.println(currentThread().getName()+ " :"+inc);
                    }
                };
            }.start();
        }
    
       // while(Thread.activeCount()>1)  //��֤ǰ����̶߳�ִ����
        //   Thread.yield();
      

        System.out.println(test.inc);
        System.out.println(test.inc);
    }
}