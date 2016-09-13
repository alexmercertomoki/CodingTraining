package banlancedtree;

import maxdepthbinarytree.MaxdepthBinaryTree.TreeNode;


public class banlancedtree {
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	 public boolean isBalanced(TreeNode root) {
	     return maxDepth(root)!=-1;
		
	 }
	 static int maxDepth(TreeNode n){
		 if(n==null) return 0;
		 int l;
		 l=maxDepth(n.left);
		 if(l==-1) return -1;
		 int r;
		 r=maxDepth(n.right);
		 if(r==-1) return -1;
		 return (Math.abs(l-r)<=1)?(Math.max(l, r)+1):-1;  //must be the maximum depth to get the answer 
	 }
}
