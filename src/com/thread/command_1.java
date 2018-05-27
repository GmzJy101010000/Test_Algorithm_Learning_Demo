package com.thread;

import java.io.*;

/**
* 这是如何使用java使用unix或者windows命令的实例
*/
public class command_1 {
 /** The program to run */
 //  public static final String PROGRAM = "ls";//这是unix系统命令
 public static final String PROGRAM ="F:/安装包/p2pSearcher/P2PSeacher.exe";
 static boolean done = false;

 public static void main(String argv[]) throws IOException {

   final Process p;     // 声明命令项
   BufferedReader is;  // 命令输出项
   String line;   
   p = Runtime.getRuntime().exec(PROGRAM);//执行命令
   // 执行命令线程，
   Thread waiter = new Thread() {
     public void run() {
       try {
         p.waitFor();
       } catch (InterruptedException ex) {
         return;
       }
       System.out.println("Program terminated!");//如果已经运行了这个程序。就输出程序已运行
       done = true;//如果执行完成设置done为真，用于判断命令结束。
     }
   };
   waiter.start();
   //以下是和获得执行结果，就是说在完成情况下输出运行结果
   is = new BufferedReader(new InputStreamReader(p.getInputStream()));
   while (!done && ((line = is.readLine()) != null))
     System.out.println(line);
   return;
 }
}