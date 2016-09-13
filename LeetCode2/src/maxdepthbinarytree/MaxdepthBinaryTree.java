package maxdepthbinarytree;

import validbtree.Btree.TreeNode;

public class MaxdepthBinaryTree {
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	 public static int maxDepth(TreeNode root) {
	      if(root==null) return 0;
	      return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	 }
	 
	 public static void main(String[] args) {
		 	TreeNode t1=new TreeNode(1);
		    TreeNode t2=new TreeNode(2);
		    TreeNode t3=new TreeNode(3);
		    TreeNode t4=new TreeNode(4);
		    TreeNode t5=new TreeNode(5);
		    TreeNode t6=new TreeNode(6);
		    t1.left=t2;
		    t1.right=t3;
		    t2.left=t4;
		    t2.right=t5;
		    t3.left=t6;
		    System.out.println(maxDepth(t1));
	 }
}
