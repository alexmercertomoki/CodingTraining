package p16;

import java.util.*;

public class EvaluatePolishReverse {
	
	public static int evalRPN(String[] tokens) { // evaluate : to get the value!
		
        Stack<String> st=new Stack<String>();
        int num1,num2,result;
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("*")){
        		num2=Integer.parseInt(st.pop());  // don't use cast 
        		num1=Integer.parseInt(st.pop());
        	    result=num1*num2;
        	    st.push(result+"");
        	}
        	else if(tokens[i].equals("/")){
        		num2=Integer.parseInt(st.pop());
        		num1=Integer.parseInt(st.pop());
        	    result=num1/num2;
        	    st.push(result+"");
        	}
        	else if(tokens[i].equals("+")){
        		num2= Integer.parseInt(st.pop());
        		num1=Integer.parseInt(st.pop());
        	    result=num1+num2;
        	    st.push(result+"");
        	}
        	else if(tokens[i].equals("-")){
        		num2=Integer.parseInt(st.pop());
        		num1=Integer.parseInt(st.pop());
        	    result=num1-num2;
        	    st.push(result+"");
        	}
        	else{
        		st.push(tokens[i]);
        	}
        	
        }
        
        result=Integer.parseInt(st.pop());
        return result;
		
    }
	  
	 public static void main(String args[]){
		 
	    String[] str={"0","3","/"}; // initialize directly   // all the constants are read at first then if using a new: the address will be changed not the original one then wrong
	    str[2] = new String("/");
	    int i= evalRPN(str);
	    System.out.println(i);
		 
	 }
	 
}
