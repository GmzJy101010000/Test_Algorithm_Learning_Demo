package com.interview;




import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.imageio.stream.FileImageInputStream;

import java.util.Scanner;

public class SsgaInterView {
   
    static  String  ml=null;
    static  Scanner s=null;
   static boolean  b=true;
   public  static  void  main(String a[]){
       
       System.out.println("请输入命令");
       while(b){
           System.out.println("1---显示所有员工信息");
           System.out.println("2---根据姓名查询员工信息");
           System.out.println("3---显示所有层级信息");
           System.out.println("8---递归显示所有层级信息");
           System.out.println("4---退出系统");
           
           s=new Scanner(System.in);
           ml=s.next();
           
           if(ml.equals("1")){
             du.show(du.duru());
           }
           if(ml.equals("2")){
               b=false;
               System.out.println("请输入员工姓名：");
                String a1=null;
                a1=s.next();
                du.findbyname(du.duru(), a1);
                b=true;
               
           }
         
           if(ml.equals("3")){
               du.showjibie();
           }
           if(ml.equals("8")){
        	   
        	   List<em> bossList = du.boss(du.duru());
        	   for(em e: bossList){
        		   du.diGuiShowEmployee(e); 
        	   }
        	  
           }
           if(ml.equals("4")){
               b=false;
               System.out.println("thanks!!");
           }
       }
       
   }
}






 class du {
    
     private static String head = "";
     private static String increse = "   ";
     
     public static java.util.List<em> duru(){
         java.util.List li = null;
         try {
             String dizhi="D:/Users/ZGM/Desktop/1.txt";
            BufferedReader b=new  BufferedReader(new FileReader(dizhi));
             String s=b.readLine();
             li=new ArrayList();
             while(s!=null){
                 em em=new em();
                 String[] strs = s.split(",");
                 em.setId(strs[0].trim());
                 em.setName(strs[1].trim());
                 if(strs.length==3){
                     em.setLeader(strs[2].trim());
                 }
                if(strs.length==2){
                    em.setLeader("null");
                }
                 li.add(em);
                 s=b.readLine();
             }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
         return li;
     }
     
     public  static  void  show(java.util.List<em>  li){
         for(int a=0;a<li.size();a++){
             em e1=(em) li.get(a);
             System.out.println(e1);
                
            }
     }
     
     public  static void findbyname(java.util.List<em> li,String aa){
         em e1=findone(li, aa);
         java.util.List<em> e2=findtop(li, aa);
         java.util.List<em> e3=findxia(li, aa);
         String  shangji=null;;
         String  xiaji=null;;
         if(e1==null){
             System.out.println("该员工不存在");
         }
         if(e2.size()==0){
             shangji="null";
         }
         if(e3.size()==0){
             xiaji="null";
         }
         System.out.println("上级：");
         if(e2.size()==0){
             System.out.println("null");
         }
       for(int a=0;a<e2.size();a++){
           System.out.println((em)e2.get(a));
       }
         System.out.println("员工："+"\n"+e1);
         System.out.println("下级：");
         if(e3.size()==0){
             System.out.println("null");
         }
         for(int a=0;a<e3.size();a++){
             System.out.println((em)e3.get(a));
         }
         
     }
     
     public static em findone(java.util.List<em> li,String  aa){
         em e=null;
         for(int a=0;a<li.size();a++){
             if(aa.equals(((em)li.get(a)).getName())){
                 e=(em)li.get(a);
                 break;
             }
         }
         
         return e;
         
     }
     
     public  static java.util.List<em>  findtop(java.util.List<em> li,String aa){
           em e=findone(li, aa);
           java.util.List<em> eList=new ArrayList<em>();
       if(e==null){
//           System.out.println("该员工不存在");
           return eList;
       }
       else{
           for(int a=0;a<li.size();a++){
               if(e.getLeader().equals(((em)li.get(a)).getName())){
                   eList.add((em)li.get(a));
               }
               
           }
       }
         return eList;
         
     }
     
     public  static java.util.List<em>  findxia(java.util.List<em> li,String aa){
         em e=findone(li, aa);
         java.util.List<em> eList=new ArrayList<em>();
      if(e==null){
//          System.out.println("该员工不存在");
          return eList;
      }
      else{
          for(int a=0;a<li.size();a++){
              if(e.getName().equals(((em)li.get(a)).getLeader())){
                  eList.add((em)li.get(a));
              }
              
          }
      }
       return eList;
       
         
         
         
     }
     
     public  static  java.util.List<em>  boss(java.util.List<em>  li){
         em  e=null;
         java.util.List<em>  bosslist =new ArrayList<em>();
         for(int  a=0;a<li.size();a++){
             if(((em)li.get(a)).getLeader().equals("null")){
                 e=(em)li.get(a);
                 bosslist.add(e);
             }
             
             
         }
         return bosslist;
     }
     //显示层级信息
     public  static void showjibie(){
         java.util.List<em>  boss=boss(duru());
        for(int b=0;b<boss.size();b++){
            em e1=(em)boss.get(b);
            java.util.List<em> erji=findxia(duru(), e1.getName());
            System.out.println(e1.getName());
            for(int a=0;a<erji.size();a++){
                System.out.println("    "+((em)erji.get(a)).getName());
                em e2=(em)erji.get(a);
                java.util.List<em>  sanji=findxia(duru(), e2.getName());
                for(int c=0;c<sanji.size();c++){
                    System.out.println("        "+((em)sanji.get(c)).getName());
                    em e3=(em)sanji.get(c);
                    java.util.List<em> siji=findxia(duru(), e3.getName());
                    for(int d=0;d<siji.size();d++){
                        System.out.println("           "+((em)siji.get(d)).getName());
                        java.util.List<em> wuji=findxia(duru(), ((em)siji.get(d)).getName());
                        for(int f=0; f<wuji.size();f++){
                        	 System.out.println("             "+((em)wuji.get(f)).getName());
                        }
                    }
                }
            }
            
        }
         
     }
     
     public static void diGuiShowEmployee(em employee){
    
         System.out.println(head+employee.getName());
         
         head+=increse;
    	 List<em> employeeList = findxia(duru(), employee.getName());
         
    	 if(employeeList.size()>0){
    		 
    		 for(int i=0;i<employeeList.size();i++){
    			 
    			 diGuiShowEmployee(employeeList.get(i));
    		 }
    	 }
    	 
    	 head = head.substring(0,head.length()-3);
    	
     }
     
     
}





 class em {   
    
   private  String  id;
   private  String name;
   private  String leader;
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getLeader() {
    return leader;
}
public void setLeader(String leader) {
    this.leader = leader;
}
   
public String toString(){
    return this.id+"  "+this.name+"   "+this.leader;
}
   
}

