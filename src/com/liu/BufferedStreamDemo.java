package com.liu;

import  java.io.*;
public class BufferedStreamDemo {

	 public   static  void  main(String  a[]) throws Exception{
		 
		 BufferedInputStream  hcin=new  BufferedInputStream(new FileInputStream("F:/ԭ����/java��/1.txt")  );
		 BufferedOutputStream  hcout=new  BufferedOutputStream(new FileOutputStream("F:/ԭ����/java��/3.txt")  );
		 
		 byte []  hc=new  byte[2048];//2048����һ�λ�����ļ���С  2048�ֽ�=2k
		 int  ff;
		 ff=hcin.read(hc);
		 while(ff!=(-1)){
			
			 hcout.write(hc, 0, ff);//��ֹ���һ��д�����ݳ��Ȳ���2048�ֽ� �뻺������һ��
//			 System.out.print((char)ff);
			 ff=hcin.read(hc);
			 System.out.println(ff);
		 }
		
		 hcout.flush();
		 hcin.close();
		 hcout.close();
	 }
}
