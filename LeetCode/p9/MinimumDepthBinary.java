package p9;

public class MinimumDepthBinary {
    static public int minDepth(TreeNode root) {
         if (root.left == null && root.right == null) {
        	 return 0;
         }
         if (root.left !=null && root.right == null) {
        	 return minDepth(root.left)+1; //can't ++ but use +1 
         }
         if (root.right != null && root.left == null) {
        	 return minDepth(root.right)+1; //can't ++ but use +1 
         }
         int leftDepth = minDepth(root.left);
         int rightDepth = minDepth(root.right);
         int minDepth = 0;
         if (leftDepth < rightDepth) {
        	 minDepth = leftDepth + 1;
         } else {
        	 minDepth = rightDepth + 1;
         }
         return minDepth;
    }
	
 
	 static class TreeNode { // should be static :  because we need an instance of MIMIMUMDepthBinary.
	     int val;
	     public TreeNode left;
	     public TreeNode right;
	     TreeNode(int x) { val = x; }
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(8);
//		t1.left=new TreeNode(9);
		t1.right=new TreeNode(10);
		t1.right.right=new TreeNode(11);
		t1.right.right.right=new TreeNode(12);
		int i =  minDepth(t1);
		System.out.println(i);
		
		

	}

}
