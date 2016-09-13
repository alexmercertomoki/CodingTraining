package p17;

import java.util.HashMap;

public class TwoSum {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index1=0,index2=0,distance;
		int target=11,value,key;
		int[] numbers= {1,2,3,5,6};
		HashMap<Integer,Integer>  h1=new HashMap<Integer,Integer>();
//		
//		for(int j=0;j<i.length;j++){
//			distance = target-i[j];
//				for(int k=j+1;k<i.length;k++){
//					if(i[k]==distance){
//						index1=j+1;
//						index2=k+1;
//					}
//				}
//		}
//		System.out.println(index1+"  "+index2);
        for(int i=0;i<numbers.length;i++){
        	
        	if(h1.containsKey(numbers[i])){ // containvalue but no get value only get key:  because  the value can point to multiple keys 
        		key = h1.get(numbers[i]);
        		index1=key+1;
        		index2=i+1;
        	}
        	h1.put(target-numbers[i], i);
        }
		System.out.println(index1+"  "+index2);
        
  
	}

}
