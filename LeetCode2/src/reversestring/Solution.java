package reversestring;

public class Solution {
	    public static String reverseWords(String s) {
	        String[] str= s.split(" ");
	        
	        StringBuilder sb=new StringBuilder();
	        for(int i=str.length-1;i>=0;i--){
//	        	if (str[i].equals(""))
//	        		continue;
	        	if(!str[i].equals("")){
	        	sb.append(str[i]);
	        	sb.append(" ");
	        	}
	        	
	        }
	        
	        String ss= sb.toString();
	        return ss.trim();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s=" a       b ";
		String srev= reverseWords(s);
		System.out.println(srev);
	}

}
