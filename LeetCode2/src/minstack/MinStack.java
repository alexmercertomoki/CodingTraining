package minstack;

import java.util.Stack;

public class  MinStack{
	 	Stack st=new Stack();
	 	Stack mst=new Stack();
		public void push(int x) {
	        st.push(x);
	        if(mst.isEmpty()||x<=(Integer)mst.peek()){
	        	mst.push(x); 
	        }
	        else{
	        	mst.push(mst.peek());
	        }
	    }

	    public void pop() {
	    	st.pop();
	    	mst.pop();
	    }

	    public int top() {
	       return  (Integer) st.peek();
	    }

	    public int getMin() {
	        return (Integer) mst.peek();
	    }
	    
	    
	    public static void main(String[] args) {
	    	MinStack m1=new MinStack();
	    	m1.push(5);
	    	m1.push(4);
	    	m1.push(4);
	    	m1.push(3);
	    	m1.push(3);
	    	m1.push(2);
	    	m1.push(1);
	    	
	    	System.out.println(m1.getMin());
		}
}
