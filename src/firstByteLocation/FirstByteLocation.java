package firstByteLocation;

import java.util.Scanner;

public class FirstByteLocation {

	public FirstByteLocation() {	
	}
    
	public static void main(String a[]){
		
		while (true) {
			System.out.println("������һ��������");
			int cv=new Scanner(System.in).nextInt();
		    StringBuffer byteString=new StringBuffer(Integer.toBinaryString(cv));
		    int len=byteString.length();
		    for(int i=0;i<16-len;i++){
		    	byteString.insert(0,"0");
		    }
		    char [] tempCharArray=byteString.toString().toCharArray();
		    System.out.println(byteString);
		  for(int i=tempCharArray.length-1;i>=0;i--){
			  if(tempCharArray[i] == '1' ){
				  System.out.println("��һ����λ����λ��:"+(15-i));
				  break;
			  }
			
		}
		  
	  }
	}
}
