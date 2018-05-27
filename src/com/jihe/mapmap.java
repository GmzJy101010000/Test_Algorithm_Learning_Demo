package com.jihe;

import java.util.HashMap;
import java.util.Map;

public class mapmap {
   public static  void main(String a[]){
	   Map<String, String >  ma = new HashMap<String, String>();
	   ma.put("1", "sdf");
	   ma.put("1", "hgh");
	   String aa=ma.get("1");
	 //  System.out.println(aa);
	   String aq=new String("a");
	   String cq=new String("a");
	   System.out.println(aq.equals(cq));
	   System.out.println(aq.hashCode() ==cq.hashCode());
	   
   }
 
}
