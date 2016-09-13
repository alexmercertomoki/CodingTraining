package p11;

import p10.MergeTwoSortedList.ListNode;

public class RemoveNthNode {

	public static class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		 
		
		 
		 ListNode prev=head; 
         ListNode cur=head; 
         ListNode distance=head; 
       
         
         
         for(int i=1;i<n;i++){
        	 distance=distance.next;
         }
        
         while(distance.next!=null){
        	 prev=cur;
        	 cur=cur.next;
        	 distance=distance.next;
         }
         if(cur==head){
        	 return head.next;
         }
         else
         prev.next=cur.next;
         
         return head;
		
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 int i=1;
		 
		 ListNode l2=new ListNode(2);
		 l2.next=new ListNode(3); 
		 l2.next.next=new ListNode(4); 
		 l2.next.next.next=new ListNode(5); 
		 l2.next.next.next.next=new ListNode(6); 
		 
		 l2= removeNthFromEnd(l2,5);
		 
//		 while(i<5){
//			 System.out.println(l2.val);
//			 i++;
//			 
//		 }
		 while(l2!=null){  // if l2 is null we quit
			 
			 System.out.println(l2.val);
			 l2=l2.next;
		 }
        
	}


}
