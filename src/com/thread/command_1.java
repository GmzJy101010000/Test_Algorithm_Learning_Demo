package com.thread;

import java.io.*;

/**
* �������ʹ��javaʹ��unix����windows�����ʵ��
*/
public class command_1 {
 /** The program to run */
 //  public static final String PROGRAM = "ls";//����unixϵͳ����
 public static final String PROGRAM ="F:/��װ��/p2pSearcher/P2PSeacher.exe";
 static boolean done = false;

 public static void main(String argv[]) throws IOException {

   final Process p;     // ����������
   BufferedReader is;  // ���������
   String line;   
   p = Runtime.getRuntime().exec(PROGRAM);//ִ������
   // ִ�������̣߳�
   Thread waiter = new Thread() {
     public void run() {
       try {
         p.waitFor();
       } catch (InterruptedException ex) {
         return;
       }
       System.out.println("Program terminated!");//����Ѿ�������������򡣾��������������
       done = true;//���ִ���������doneΪ�棬�����ж����������
     }
   };
   waiter.start();
   //�����Ǻͻ��ִ�н��������˵����������������н��
   is = new BufferedReader(new InputStreamReader(p.getInputStream()));
   while (!done && ((line = is.readLine()) != null))
     System.out.println(line);
   return;
 }
}