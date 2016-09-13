package stackqueue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuetoStack {
	
	Queue<Integer> q1=new ArrayBlockingQueue<Integer>(4);
	Queue<Integer> q2=new ArrayBlockingQueue<Integer>(4);
    int flag=0;
	
			
    void push(int i){
    	flag++;
    	if(flag%2==1){
    	    q1.add(i);
    	    if(q2!=null){
    	    	q1.addAll(q2);
    	    	q2.removeAll(q2);
    	    }
    	}
    	if(flag%2==0){
    		q2.add(i);
    		 if(q1!=null){
     	    	q2.addAll(q1);
     	    	q1.removeAll(q1);
     	    }
    		
    	}
    	
    }
    int pop(){
    	if(q1.isEmpty()){
    		int rel=q2.peek();
    		q2.remove(q2.peek());
    		return rel;
    		
    	}
    	else if(q2.isEmpty()){
    		int rel=q1.peek();
    		q1.remove(q1.peek());
    		return rel;
    		
    	}
    	else
    		return -1;
    }
    int peek(){
    	if(q1.isEmpty()){
    		int rel=q2.peek();
    		
    		return rel;
    		
    	}
    	else if(q2.isEmpty()){
    		int rel=q1.peek();
    		
    		return rel;
    		
    	}
    	else
    		return -1;
    }
    
    

}
