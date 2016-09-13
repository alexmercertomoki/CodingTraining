package longestsubstringwithoutrepeating;

import java.util.HashMap;

public class LongSubSecond {
	 public static int lengthOfLongestSubstring(String s) {
		  
		 StringBuilder sb=new StringBuilder();
		 String stemp =new String();
	      for(int i=0;i<s.length();i++){
	    	 if(Character.isAlphabetic(s.charAt(i))){
	    		String c=String.valueOf(s.charAt(i));
	    		if(stemp.contains(c)){
	    			
	    		}
	    		sb.append(s.charAt(i));
	    		stemp=sb.toString();
	    		
	    	 }
	      }
	      return 1;
    }
	 public static void main(String[] args) {
		 	String s ="pwwkew";
			int n =lengthOfLongestSubstring(s);
			System.out.println(n);
	}
}
