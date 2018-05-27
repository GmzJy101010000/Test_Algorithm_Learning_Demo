package banksortsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class OrderSystem {

	public OrderSystem() {
		// TODO Auto-generated constructor stub
	}

	
  public static void main(String a[]) throws IOException{
		
	    List<Integer> numberList=new ArrayList<Integer>(); 
	    List<Integer> VIPNumberList=new ArrayList<Integer>(); 
	    Map<String, List<Integer>>  numMap=new HashMap<String, List<Integer>>();
	    numMap.put("normal", numberList);
	    numMap.put("vip", VIPNumberList);
	    int startValue=1;

		while (true) {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String command=br.readLine();
		    if(command!=null && !command.equals("")){
		       if(command.equals("quit")){
			    	System.out.println("感谢使用叫号系统！！");
			    	System.exit(0);
			    }
		    	else  if(command.equals("get")){
			    	numberList.add(Integer.valueOf(startValue));
			    	System.out.println(startValue);
			    	startValue++;
			    }
			    else if(command.equals("get vip")){
			    	VIPNumberList.add(Integer.valueOf(startValue));
			    	System.out.println("vip "+startValue);
			    	startValue++;
			    }
			    else if(command.equals("reset")){
			    	startValue=1;
			    	numberList=null;
			    	VIPNumberList=null;
			    	numberList=new ArrayList<Integer>();
			    	VIPNumberList=new ArrayList<Integer>();
			    }
			    
			    else if(command.equals("call")){
			    	String result=getNextUser(numMap);
			    	if(result==null){
			    		System.out.println("call error,no user line up now");
			    	}
			    	else{
			    		System.out.println(result);
			    	}
			    }
			    else if(command.startsWith("delete") && command.split(" ").length==2){
			    	
			    	int deleteNum=Integer.valueOf(command.split(" ")[1]).intValue();
			    	int numbegin=numberList.size();
			    	int vipbefin=VIPNumberList.size();
			    	if(numbegin==0 && vipbefin==0){
			    		System.out.println("delete error,no user line up now");
			    	}
			    	else{
			    		numberList.remove(new Integer(deleteNum));
				    	VIPNumberList.remove(new Integer(deleteNum));
				    	
				    	int numfinish=numberList.size();
				    	int vipfinish=VIPNumberList.size();
				    	
				    	if(numbegin!=numfinish){
				    		
				    		System.out.println("delete normal user: "+deleteNum);
				    	}
				    	if(vipbefin!=vipfinish){
				    		System.out.println("delete vip user: "+deleteNum);
				    	}
				    	if(numbegin == numfinish && vipbefin == vipfinish){
				    		System.out.println("delete error,no such user line up now");
				    	}
				    	if(deleteNum == startValue-1){
				    		startValue-=1;
				    	}
				    	
			    	}
			    }
			    else if(command.equals("count")){
			    	System.out.println(numberList.size()+VIPNumberList.size());
			    }
			    
			    else if(command.startsWith("countN") && command.split(" ").length == 2 ){
			    	int countUserBeforeNum=Integer.valueOf(command.split(" ")[1]).intValue();
			    	String userType=getUserType(numMap, countUserBeforeNum);
			    	if(userType==null){
			    		System.out.println("error, no such user line up now,can't count how many users before him");
			    	}
			    	else if(userType.equals("vip")){
			    		int countUsers=getTotalUsersBeforeSpecifiedNum(VIPNumberList,countUserBeforeNum);
			    		System.out.println("There are "+countUsers+" users before you!");
			    	}
			    	else{
			    		int countUsers=getTotalUsersBeforeSpecifiedNum(numberList,countUserBeforeNum);
                       if(VIPNumberList.size()!=0){
			    			countUsers+=VIPNumberList.size();
			    		}
			    		System.out.println("There are "+countUsers+" users before you!");
			    		
			    	}
			    	
			    }
			    else{
			    	System.out.println("命令错误，请重新输入：");
			    }
		    }
		
		  
	  }  //
  }
   public static String getNextUser(Map<String, List<Integer>> map) {
	    List<Integer> numList=map.get("normal");
	    List<Integer> vipNumList=map.get("vip");
	    String result;
	    if(vipNumList.size()!=0){
	    	int nextNumber=getNextNumber(vipNumList);
	    	if(nextNumber ==0){
	    		return null;
	    	}
	    	vipNumList.remove(new Integer(nextNumber));
	    	result="vip "+nextNumber;
	    }
	    else{
	    	int nextNumber=getNextNumber(numList);
	    	if(nextNumber ==0){
	    		return null;
	    	}
	    	numList.remove(new Integer(nextNumber));
	    	result=String.valueOf(nextNumber);
	    }
	  return result;
  }
   
   public static int getNextNumber(List<Integer>  numList){
	   
	  int result=0;
	   if(numList.size()!=0){
		   int [] numArray;  numArray= new int[numList.size()];
		   for(int i=0;i<numList.size();i++){
			   numArray[i]=numList.get(i).intValue();
		   }
		   for(int j=0;j<numArray.length;j++){
		
			   for(int k=0;k<numArray.length;k++){
				   if(numArray[j]<numArray[k]){
					   int temp=numArray[j];
					   numArray[j]=numArray[k];
					   numArray[k]=temp;
				   }
			   }
			   
		   }
		   result=numArray[0];
	   }
	  
	   return result;
   }
   
   public static String getUserType(Map<String, List<Integer>> map,int userNum){
	   List<Integer> numList=map.get("normal");
	   List<Integer> vipNumList=map.get("vip");
	   String result = null;
	   if(numList.size() != 0 ||vipNumList.size()!=0){
		  //for normal user list
		   int [] numArray;  numArray= new int[numList.size()];
		   for(int i=0;i<numList.size();i++){
			   numArray[i]=numList.get(i).intValue();
		   }
		   for(int j=0;j<numArray.length;j++){
		    if(numArray[j]==userNum){
		    	result="normal";
		    }
			   
		   }
		   //for VIP user list
		   int [] vipnumArray= new int[vipNumList.size()];
		   for(int i=0;i<vipNumList.size();i++){
			   vipnumArray[i]=vipNumList.get(i).intValue();
		   }
		   for(int j=0;j<vipnumArray.length;j++){
		    if(vipnumArray[j]==userNum){
		    	result="vip";
		    } 
		   }
	   }
	   else{
		   
	   }
	   return result;
   }
   
   public static int getTotalUsersBeforeSpecifiedNum(List<Integer>  list,int num) {
	
	   int result=0;
	   if(list.size()!=0){
		   int [] numArray;  numArray= new int[list.size()];
		   for(int i=0;i<list.size();i++){
			   numArray[i]=list.get(i).intValue();
			   
		   }
		   for(int j=0;j<numArray.length;j++){
		
			   for(int k=0;k<numArray.length;k++){
				   if(numArray[j]<numArray[k]){
					   int temp=numArray[j];
					   numArray[j]=numArray[k];
					   numArray[k]=temp;
				   }
			   }
			   
		   }
		   for(int jj=0;jj<numArray.length;jj++){
			   if(numArray[jj]==num){
				   result=jj;
			   }
			   
		   }
		   
	   }
	   return result;
}
}
