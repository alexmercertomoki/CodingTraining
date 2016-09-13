package twosum;

import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
    	
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int j=0; j < numbers.length; j++){
            int k = target - numbers[j];
            if(hm.containsKey(numbers[j])){
                return new int[]{hm.get(numbers[j])+1,j+1}; // put into the array the first number index and the second 
            }
            hm.put(k,j);
        }
        
		return new int[]{0,0};
		
    }
    
    public static void main(String[] args) {
    	 int numbers[]={2, 7, 11, 15};
    	 System.out.println(twoSum(numbers,9)[0]);
    	 System.out.println(twoSum(numbers,9)[1]);
	}
    
}