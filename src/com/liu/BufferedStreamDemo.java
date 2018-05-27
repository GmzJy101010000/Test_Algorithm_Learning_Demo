package com.liu;

import  java.io.*;
public class BufferedStreamDemo {

	 public   static  void  main(String  a[]) throws Exception{
		 
		 BufferedInputStream  hcin=new  BufferedInputStream(new FileInputStream("F:/原代码/java流/1.txt")  );
		 BufferedOutputStream  hcout=new  BufferedOutputStream(new FileOutputStream("F:/原代码/java流/3.txt")  );
		 
		 byte []  hc=new  byte[2048];//2048就是一次缓冲的文件大小  2048字节=2k
		 int  ff;
		 ff=hcin.read(hc);
		 while(ff!=(-1)){
			
			 hcout.write(hc, 0, ff);//防止最后一次写入数据长度不足2048字节 与缓冲区不一致
//			 System.out.print((char)ff);
			 ff=hcin.read(hc);
			 System.out.println(ff);
		 }
		
		 hcout.flush();
		 hcin.close();
		 hcout.close();
	 }
}
