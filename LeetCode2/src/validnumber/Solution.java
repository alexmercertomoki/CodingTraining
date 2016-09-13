package validnumber;

public class Solution {
    public static  boolean isNumber(String s) {
    	boolean num=false;
    	int i=0;
    	int len=s.length();
    	while(i<len && Character.isWhitespace(s.charAt(i))){
    		i++;
    	}
    	while(i<len && Character.isDigit(s.charAt(i))){
    		    num=true;
    	}  
    	if(i<len&&s.charAt(i)=='.'){
    		i++;
    		while(i<len&&Character.isDigit(s.charAt(i))){
    			i++;
    			num=true;
    		}
    	}
    	if(num=false&&i<len&&(s.charAt(i)=='e')){
    		i++;
    		while(i<len&&Character.isDigit(s.charAt(i))){
    			i++;
    			num=true;
    		}
    	}
    	while(i<len&&Character.isWhitespace(s.charAt(i))){
    		i++;
    	}
    	
    	return i==len&&num;
    }
}