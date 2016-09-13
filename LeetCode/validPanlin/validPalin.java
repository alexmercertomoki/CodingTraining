package validPanlin;

public class validPalin {
	  public static boolean isPalindrome(String s) {
	        StringBuilder str1=new StringBuilder();
	        StringBuilder str2=new StringBuilder();
	        boolean isPalin;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='0'&&s.charAt(i)<='9'){
	             str1.append(s.charAt(i));
	             str2.append(s.charAt(i));
	            }
	        }
	        str1.reverse();
	        String s1=str1.toString();
	        
	        s1=s1.toLowerCase();
	        String s2=str2.toString();
	        
	        s2=s2.toLowerCase();
	        
	        System.out.println(s1);
	        System.out.println(s2);
	        
	        isPalin=s1.equals(s2);
	        return isPalin;
	    }
	  public static void main(String arg[]){
		boolean a =  isPalindrome("aA");
		System.out.print(a);
		
	  }
}
