package p7;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>(); 
     // StringBuffer a=new StringBuffer();
        char a,b;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(')
        	st.push(s.charAt(i));
        	if(s.charAt(i)=='}'||s.charAt(i)==']'||s.charAt(i)==')')
        	{
        	   // a.append(st.pop());
        		if(st.empty()){
        			return false;
        		}
        	   a=s.charAt(i);
        	   b=st.pop(); // if null careful
        	   if((a=='}'&&b!='{')||(a==']'&&b!='[')||(a==')'&&b!='(')){
        		   return false;
        	   }
        	}
        }
        
        if(st.empty())
         return true;
        else
         return false;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = new String("]]]");
		System.out.println(isValid(a));
		
	}

}
