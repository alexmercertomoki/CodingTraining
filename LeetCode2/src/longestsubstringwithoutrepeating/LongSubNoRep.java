package longestsubstringwithoutrepeating;

import java.util.HashMap;

public class LongSubNoRep {
	  public static int lengthOfLongestSubstring(String s) {
		  HashMap hm=new HashMap();
		  
	      for(int i=0;i<s.length();i++){
	    	 if(Character.isAlphabetic(s.charAt(i))){
	    		 hm.put(s.charAt(i), i);
	    	 }
	      }
		  int n = hm.size();
		  return n;
	  }
	  
	  public static void main(String[] args) {
		String s ="aaaabbbcs";
		int n =lengthOfLongestSubstring(s);
		System.out.println(n);
	}
}
