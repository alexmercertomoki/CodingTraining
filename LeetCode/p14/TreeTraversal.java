package p14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



public class TreeTraversal { //iterative
	  
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	 public static List<Integer> preorderTraversal(TreeNode root) {
		 List<Integer> l1=new ArrayList<Integer>(); 
		 Stack<TreeNode> st=new Stack();
//		 TreeNode tn=root;
		 if(root==null){
			 return l1;
		 }
		 TreeNode tp;
		 st.push(root);
		 while(!st.empty()){
			tp=st.pop();
			l1.add(tp.val);
			if(tp.right!=null){
			 st.push(tp.right);
			}
			if(tp.left!=null){
				st.push(tp.left);
		    }   
		 }
		 
		 return l1;
		 
	 }
	  
	  
	  public static void main(String args[]){
		 TreeNode tn=new TreeNode(0);
         tn.left=new TreeNode(1);
         tn.left.left=new TreeNode(2);
         tn.left.right=new TreeNode(2);
         tn.right=new TreeNode(3);
         preorderTraversal(tn);
         ArrayList<Integer> l=new ArrayList<Integer>();
         l= (ArrayList<Integer>) preorderTraversal(tn);
         Iterator<Integer> i= l.iterator();
         
         while(i.hasNext()){
        	 System.out.println(i.next());
         }
           
		  
	  }
	  
	  
}
