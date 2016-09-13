package p15;

import java.util.*;

import p14.TreeTraversal.TreeNode;

public class BinaryTreeTraversal {


	 public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> l1=new LinkedList<List<Integer>>(); 
		 List<Integer> x=new ArrayList<Integer>(); 
		 Queue<TreeNode> que=new LinkedList<TreeNode>();// should use linkedlist to implement 
		 int curN=1,nextN=0;
		 TreeNode tp;
		 if(root==null){
			 return l1;
		 }
		 
		 que.offer(root); // offer = add , poll = remove
		 while(!que.isEmpty()) {  //isEmpty
			
			tp=que.poll();
			x.add(tp.val);
			curN--;
			
			if(tp.left!=null){
				que.offer(tp.left);
				nextN++;
				
			}
			if(tp.right!=null){
				que.offer(tp.right);
				nextN++;
			}
			if(curN==0){
				l1.add(x);
				curN=nextN;
				nextN=0;
				x=new ArrayList<Integer>(); 
			}
			
		 }
		 return l1;
		    
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode tn=new TreeNode(0);
        tn.left=new TreeNode(1);
        tn.left.left=new TreeNode(2);
        tn.left.right=new TreeNode(2);
        tn.right=new TreeNode(3);
        List<List<Integer>> l= levelOrder(tn);
        List<Integer> l1=new ArrayList<Integer>();
        Iterator<List<Integer>> i= l.iterator();
        Iterator<Integer> i1;
        while(i.hasNext()){
        	l1=i.next();
        	i1= l1.iterator(); // everytime new iterator 
        	while(i1.hasNext()){
        		System.out.print(i1.next()+" ");
        		
        	}
        	System.out.println();
        	
        }
      	
        
	}

}
