package com.liu;

import   java.io.*;
import java.util.ArrayList;
import java.util.List;

public class liu_1{
	public  static   void  main(String  a[]) throws Exception{
		FileInputStream   wj=new  FileInputStream("F:/Ô­´úÂë/javaÁ÷/src/liu_1.java");
		int  aa=wj.read();
	List b=new ArrayList();
		while(aa!=-1){
		
			aa=wj.read();
			char t=(char)aa;
			b.add(t);
//			System.out.print((char)aa);
		}
		wj.close();
		System.out.println(Character.valueOf((char)(b.get(9))));
	}
}