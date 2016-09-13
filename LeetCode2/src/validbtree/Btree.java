package validbtree;

public class Btree {
	public static boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		return isLess(root.left,root.val)&&isGreat(root.right,root.val)&&isValidBST(root.left)&&isValidBST(root.right);
		
    }
	
	static boolean  isLess(TreeNode t, int val){
		if(t==null) return true;
		return t.val<val&&isLess(t.left,val)&&isLess(t.right,val);
	}
	

	static boolean isGreat(TreeNode t, int val){
		if(t==null) return true;
		return t.val>val&&isGreat(t.left,val)&&isGreat(t.right,val);
	}
	
	  public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
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
	   System.out.println(isValidBST(t1));
	    
	}
}


