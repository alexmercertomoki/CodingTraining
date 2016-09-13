package stringtointeger;

public class Solution {
	
    public static int atoi(String str) {
    	 int nearmax=Integer.MAX_VALUE/10;
    	 int sign=1;
    	 int num=0;
    	 int flag=0;
    	
        for(int i=0;i<str.length();i++){
        	
        	if(str.charAt(i)=='-'){
        		sign=-1;
        		flag++;
        		
        	}
        	
        	if(str.charAt(i)=='+'){
        		flag++;
        	}
        	
//        	if(num>0&&Character.isWhitespace(str.charAt(i))){
//        		return 0;
//        	}
        	
        	if(Character.isDigit(str.charAt(i))){
        		int addition= Character.getNumericValue(str.charAt(i));
        		
        		if(num>nearmax||num==nearmax&&addition>8){
        			return sign==-1?-Integer.MAX_VALUE:Integer.MAX_VALUE;
        			
        		}
        		
        		num=num*10+addition;
        		
        	}
        		if(Character.isAlphabetic(str.charAt(i))){
        		return num*sign;
        	}
        	
        	
    //Input:"  +0 123"
    // Output:	123
        		
        }
    	if(flag>1){
    		return 0;
    	}
    	else{
    		return num*sign;
    	}
    }
    public static void main(String[] args) {
		String s ="  +0 123";
		int atoinumber  = atoi(s);
		System.out.println(atoinumber);
	}
}
