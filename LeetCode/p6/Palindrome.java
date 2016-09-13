package p6;

public class Palindrome { 
		 public static boolean isPalindrome(String s) {
		    StringBuffer strs=new StringBuffer("");
		    StringBuffer strs2=new StringBuffer("");
		    for(int a=0;a<s.length();a++){
		       if(s.charAt(a)>='a'&&s.charAt(a)<='z' || s.charAt(a)>='A'&&s.charAt(a)<='Z'|| s.charAt(a)>='0'&&s.charAt(a)<='9'){//单引号为字符 双为字符串   注意A a 本身
		           strs.append(s.charAt(a));
		       }
		    }
		    
		   String sa = strs.toString();
		   sa=sa.toLowerCase(); //the original string wont be changed 
		   
		   strs2=strs.reverse();
		   String sb=strs2.toString();
		   sb=sb.toLowerCase();
//		   System.out.println(sb);
//		   System.out.println(sa);
		   for(int b=0;b<sb.length();b++)
		   {
			   if(sb.charAt(b)!=sa.charAt(b)){
				   return false;
			   }
			  
		   }
		   return true;
		   
		    
		 }
		 public static void main(String args[]){
			 String a ="1a2";
			 System.out.println(isPalindrome(a));
			 
			 
		 }
	  
}
