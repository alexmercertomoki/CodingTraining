
public class TestTwoSum {

	/**
	 * @param args
	 */
	static int[] a={1,3,5,6,8};
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum t1=new TwoSum();
		System.out.println(t1.twoSum(a,8));
		
		 for (int element : t1.twoSum(a,8))   
		 {
		      System.out.println(element);

		 }

	}

}
