package p13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class TreeTraversal {
	  
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	 public static List<Integer> preorderTraversal(TreeNode root) {
		 LinkedList<Integer> l1=new LinkedList<Integer>();
		 if(root==null){
			return l1;
		 } else {
	    
		 l1.addAll(preorderTraversal(root.left));
		 l1.addAll(preorderTraversal(root.right)); // pre  post in order
		 l1.add(root.val); 
		 return l1;
		 }
		     
	 }
	  
	  
	  public static void main(String args[]){
		 TreeNode tn=new TreeNode(0);
         tn.left=new TreeNode(1);
         tn.left.left=new TreeNode(2);
         tn.left.right=new TreeNode(2);
         tn.right=new TreeNode(3);
         preorderTraversal(tn);
         LinkedList<Integer> l=new LinkedList<Integer>();
         l=(LinkedList<Integer>) preorderTraversal(tn);
         Iterator<Integer> i= l.iterator();
         
         while(i.hasNext()){
        	 System.out.println(i.next());
         }
           
		  
	  }
	  
	  
}
