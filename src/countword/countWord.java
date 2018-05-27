package countword;

import java.util.ArrayList;

import java.util.List;





public class countWord {
   public static void main (String a[]){
    String sa=" . . . .......  ...  fdg   ,,,, , ,  fg  jk  n,bm   fdg  ,,,  .,.,.,.   fg  jk  nbm   fdg  ..    fg  jk  nbm   fdg       fg  jk  nbm.....   ";
    String sb=" bv. ";
     countWords(sa);  
     String [] fdS=sa.split(",");
   //  System.out.println(sb.split("\\.").length);
     
 // System.out.println(removRepeatChar(sa, ','));
   
   }
   
   public static void countWords(String text){
       char[] legalChars={'a','b','c','d','e','f','g','h','i','j','k','l','m',
               'n','o','p','q','r','s','t','u','v','w','x','y','z',',','.',' ','A','B','C','D','E','F','G','H','I','J','K','L','M',
               'M','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
     if(text.length()==0){
         System.out.println(0);
         System.exit(0);
     }
     else if(text.length() > 500){
         System.out.println(-1);
         System.exit(0);
     }
     else{
         char [] textChar=text.toCharArray();
        
         for(int i=0;i<text.length();i++){
             char temp=textChar[i];
            
             for(int j=0; j<legalChars.length;j++){
                
                 char legal=legalChars[j];
                 if(temp ==legal){
                     break;
                 }
                 if(j==legalChars.length-1){
                     System.out.println(-1);
                    // System.out.println(temp);
                     System.exit(0);
                 }
             
             }
             
         }
         
     }
    //start to count words 
     if(checkIfNoENGChar(text)){
    	 System.out.println(0);
     }else{
    	 if(!haveSpage(text)){
    	        
             if(!havePoint(text) && !haveComma(text)){
                System.out.println(1);
             }
             else if(!havePoint(text) && haveComma(text)){
            	//remove repeat comma
            	text=text.substring(0, text.length());
            	text=removRepeatChar(text, ',');
            	if(text.startsWith(",")){
            		text=text.substring(1, text.length());
            	}
                System.out.println(text.split(",").length);
             }
             else if(havePoint(text) && !haveComma(text)){ 
               //remove repeat point
            	 text=text.substring(0, text.length());
             	text=removRepeatChar(text, '.');
             	if(text.startsWith(".")){
            		text=text.substring(1, text.length());
            	}
               System.out.println(text.split("\\.").length);
             }
             else{
                 int sum=0;  
             	text=removRepeatChar(text, '.');
            	text=removRepeatChar(text, ',');
            	while(text.startsWith(".") ||text.startsWith(",")){
            		text=text.substring(1, text.length());
            	}
            	 String[] sentence=text.split("\\.");
                 for(int i=0;i<sentence.length;i++){
                     String st=sentence[i];
                     String[] subsentence=st.split(",");
                    sum+=subsentence.length;     
                 }
                 
                System.out.println(sum); 
             }
         }
         else{
        
             if(!havePoint(text) && !haveComma(text)){
                 //remove repeat space
            	 text=removRepeatChar(text, ' ');
            	 if(text.startsWith(" ")){
             		text=text.substring(1, text.length());
             	}
                 System.out.println(text.split(" ").length);
             }
             else if(!havePoint(text) && haveComma(text)){
                
                 int sum=0;
                 text=removRepeatChar(text, ' ');
                 text=removRepeatChar(text, ',');
                 while(text.startsWith(" ") ||text.startsWith(",")){
             		text=text.substring(1, text.length());
             	}
                
                 String[] sentence=text.split(",");
                 for(int i=0;i<sentence.length;i++){
                	 
                     String st=sentence[i];
                     if(st.equals(" ")){
                    	 continue;
                     }
                     if(st.startsWith(" ")){
                  		st=st.substring(1, st.length());
                  	}
                     
                     sum+=st.split(" ").length;
                   
                 } 
                 System.out.println(sum);
             }
             else if(havePoint(text) && !haveComma(text)){
                
                 int sum=0;
                 
                 text=removRepeatChar(text, ' ');
                 text=removRepeatChar(text, '.');
                 while(text.startsWith(" ") ||text.startsWith(".")){
             		text=text.substring(1, text.length());
             	}
                
                 String[] sentence=text.split("\\.");
                 for(int i=0;i<sentence.length;i++){
                	 
                     String st=sentence[i];
                     if(st.equals(" ")){
                    	 continue;
                     }
                     if(st.startsWith(" ")){
                   		st=st.substring(1, st.length());
                   	}
                   
                     sum+=st.split(" ").length;
                   
                 } 
                 System.out.println(sum);
             }
             else{
                
                 int sum=0;
                 
                 text=removRepeatChar(text, ' ');
                 text=removRepeatChar(text, '.');
                 text=removRepeatChar(text, ',');
                 
                while(text.startsWith(" ") ||text.startsWith(".") ||text.startsWith(",")){
              		text=text.substring(1, text.length());
              	}
                 
                
                 String[] sentence=text.split("\\.");
                 for(int i=0;i<sentence.length;i++){
                     String st=sentence[i];
                     if(st.equals(" ")){
                    	 continue;
                     }
                     if(st.startsWith(" ")){
                  		st=st.substring(1, st.length());
                  	}
                     
                     if(st.equals(",")){
                    	 continue;
                     }
                     if(st.startsWith(",")){
                  		st=st.substring(1, st.length());
                  	}
                     
                     String[] subsentence=st.split(",");
                     for(int j=0;j<subsentence.length;j++){
                         String ssubsenten=subsentence[j];
                         
                         if(ssubsenten.equals(" ")){
                        	 continue;
                         }
                         if(ssubsenten.startsWith(" ")){
                        	 ssubsenten=ssubsenten.substring(1, ssubsenten.length());
                      	}
                         int subsum=ssubsenten.split(" ").length;
                         sum+=subsum;
                         
                     }
                    
                     
                 }
                 System.out.println(sum); 
                 
             }
             
         }
          
    	 
     }
    
   }
   // return true if no English word
   public static boolean checkIfNoENGChar(String checkString){
	   
	   char[] checkChar={' ',',','.'};
	   
	   char [] textChar=checkString.toCharArray();
       
       for(int i=0;i<checkString.length();i++){
           char temp=textChar[i];
          
           for(int j=0; j<checkChar.length;j++){
              
               char legal=checkChar[j];
               if(temp ==legal){
                   break;
               }
               if(j==checkChar.length-1){
                 return false;
               }
           
           }
       }
	   return true;
   }
   
  public static boolean haveSpage(String checkString){
	   
	   char[] checkChar={' '};
	   
	   char [] textChar=checkString.toCharArray();
       
       for(int i=0;i<checkString.length();i++){
           char temp=textChar[i];
          
           for(int j=0; j<checkChar.length;j++){
              
               char legal=checkChar[j];
              
               if(temp !=legal){
            	   break;
               }
               else{
            	   return true;
               }
           
           }
       }
	   return false;
   }
  
  public static boolean haveComma (String checkString){
	   
	   char[] checkChar={','};
	   
	   char [] textChar=checkString.toCharArray();
      
      for(int i=0;i<checkString.length();i++){
          char temp=textChar[i];
         
          for(int j=0; j<checkChar.length;j++){
             
              char legal=checkChar[j];
             
              if(temp !=legal){
           	   break;
              }
              else{
           	   return true;
              }
          
          }
      }
	   return false;
  }
  
  public static boolean havePoint (String checkString){
	   
	   char[] checkChar={'.'};
	   
	   char [] textChar=checkString.toCharArray();
     
     for(int i=0;i<checkString.length();i++){
         char temp=textChar[i];
        
         for(int j=0; j<checkChar.length;j++){
            
             char legal=checkChar[j];
            
             if(temp !=legal){
          	   break;
             }
             else{
          	   return true;
             }
         
         }
     }
	   return false;
 }
  public static String removRepeatChar(String text,char repeat){
	  
	  char [] textCharArray=text.toCharArray();
	  List<Integer>  indexList=new ArrayList<Integer>();
	  
	  Integer from=null;
	  Integer to=null;
	  StringBuffer sb=new StringBuffer();
	  for(int i=0;i<textCharArray.length;i++){
		char temp=textCharArray[i];
		if(temp==repeat){
		   from=Integer.valueOf(i);
		   while(i<textCharArray.length-1&&repeat == textCharArray[++i]){
			   to=Integer.valueOf(i);
		   }
		   if(to!=null){
			   indexList.add(from);
			   indexList.add(to);
			   from=null;
			   to=null;
		   } 
		}  
	  }
	  Integer first=null;
	  if(indexList.size()!=0){
		  first=indexList.get(0);
	  }
	  if(first!=null){
		  if(first.intValue()==0){
				 // sb.append(repeat);
				  for(int i=1;i<indexList.size();i+=2){
					 
					 if(i!=indexList.size()-1){
						 String temp=text.substring(indexList.get(i).intValue()+1, indexList.get(i+1).intValue());
						 sb.append(temp).append(repeat); 
					 } 
					 else{
						int last=indexList.get(i).intValue();
						if(last==textCharArray.length-1){
							continue;
						}
						else{
							 String temp=text.substring(indexList.get(i).intValue()+1,textCharArray.length);
							 sb.append(temp); 
						} 
					 }
				  }  
			  }
			  else{
				  
				  for(int i=0;i<indexList.size();i+=1){
						 
						 if(i==0){
							 String temp=text.substring(0, indexList.get(i).intValue());
							 sb.append(temp).append(repeat); 
						 } 
						 else if(i ==indexList.size()-1){
							 int last=indexList.get(i).intValue();
								if(last==textCharArray.length-1){
									continue;
								}
								else{
									 String temp=text.substring(indexList.get(i).intValue()+1,textCharArray.length);
									 sb.append(temp); 
									
								}
						 }
						 else{
							
							 String temp=text.substring(indexList.get(i).intValue()+1, indexList.get(i+1).intValue());
							 sb.append(temp).append(repeat); 
							
							 i+=1;
							
						 }
				  }
			  }
	  }else{
		return text;  
	  }
	  return sb.toString();
  }
}