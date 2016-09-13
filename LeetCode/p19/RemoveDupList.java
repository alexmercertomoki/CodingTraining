package p19;

import p11.RemoveNthNode.ListNode;

public class RemoveDupList {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
	 public static ListNode deleteDuplicates(ListNode head) {
	        ListNode  comp =head;
	        ListNode  move =head;
	        
	       if(head==null)
	    	   return null;
	       
	        while(move!=null){
	        	if(comp.val!=move.val){
	        		comp.next=move;
	        		comp=comp.next;
	        	}
	        	move=move.next;
	        }
	        comp.next=null;
	        return head;
	 }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ListNode l2=new ListNode(2);
		 l2.next=new ListNode(2); 
		 l2.next.next=new ListNode(2); 
		 l2.next.next.next=new ListNode(5); 
		 l2.next.next.next.next=new ListNode(6); 
		 l2.next.next.next.next.next=new ListNode(6); 
		 
		l2= deleteDuplicates(l2);
		while(l2!=null){  // l2.next=null there is still one l2
			System.out.println(l2.val);
			l2=l2.next;
		}
		 
        
		
	}

	
}
