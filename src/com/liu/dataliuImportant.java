package com.liu;

import   java.io.*;
public class dataliuImportant {
     public   static  void  main(String  args[]) throws Exception{
    	 ByteArrayOutputStream  a=new ByteArrayOutputStream();
    	 DataOutputStream   b=new DataOutputStream(a);
    	 long  aa=123456789;
    	 b.writeLong(aa);
    	 byte  [] c=a.toByteArray();
    	 
    	 ByteArrayInputStream  d=new ByteArrayInputStream(c);
    	 DataInputStream   e=new DataInputStream(d);
    	 long  a1;
    	 a1=e.readLong();
    	 System.out.println(a1);
    	 //��δ���  ����ʽ��  ��������ʱ�ǳ���Ҫ
     }
}
