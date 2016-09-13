package p10;

import java.util.Iterator;

public class MergeTwoSortedList {
	  
     public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
			ListNode  l3=null;
			ListNode  head=null;
			
			
			if(l1==null){
				return l2;
			}
			
			if(l2==null){
				return l1;
			}
			
			
		while(l1!=null&&l2!=null){
//		    System.out.println(l1);
//		    System.out.println(l2);
		    if(l1.val < l2.val){
		    	if(l3==null){
		    	    l3=l1;
		    	    head=l1;
		    	    l1=l1.next;
		    	}else{
		    	   l3.next=l1;
		    	   l1=l1.next;
		    	   l3=l3.next;
 		    	}
		    	
		    }
		    
		    else{
		    	if(l3==null){
		    	    l3=l2;
		    	    head=l2;
		    	    l2=l2.next;
		    	    
		    	}else{
		    		
		    		l3.next=l2; 
		    		l2=l2.next;
		    		l3=l3.next;
		    			
		    	}
		 }
		    
		 if(l1==null){
			l3.next = l2;
		 }
		 
		 if(l2==null){
			 l3.next = l1;
		 }	
			
		}
		
		return head;
	        
	 }

	 public static void main(String args[]){
		 
//		 LinkedList<Integer> l1=new LinkedList<Integer>();
//		 LinkedList<Integer> l2=new LinkedList<Integer>();
//		 l1.add(1);
//		 l1.add(2);
//		 l1.add(3);
//		 l1.add(4);
//		 l1.add(5);
		 
//		 l2.add(1);
//		 l2.add(2);
//		 l2.add(3);
//		 l2.add(4);
//		 l2.add(5);
		 
		 ListNode l1=new ListNode(1);
		 l1.next=new ListNode(2); 
		 l1.next.next=new ListNode(3); 
		 l1.next.next.next=new ListNode(4); 
		 
		 ListNode l2=new ListNode(2);
		 l2.next=new ListNode(3); 
		 l2.next.next=new ListNode(4); 
		 l2.next.next.next=new ListNode(5); 
		 l2.next.next.next.next=new ListNode(6); 
		 ListNode l3= mergeTwoLists(l1,l2);
		 while(l3!=null){
		 System.out.println(l3.val);
		 l3=l3.next;
		 }
		 
		 
		 
	 }
}
