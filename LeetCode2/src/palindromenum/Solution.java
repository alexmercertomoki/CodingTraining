package palindromenum;

public class Solution {
    public static boolean isPalindrome(int x) {
        int rev=0;
        int num=x;
        while(x!=0){
        	rev=x%10+rev*10;
        	x=x/10;
        }
        if(rev==num){
        	return true;
        }
        else{
        	return false;
        }
        	
    }
    public static void main(String[] args) {
    	
		int a=-2147447412;
		
		System.out.println(isPalindrome(a));
		
	}
}