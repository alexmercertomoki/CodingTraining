package p20;

import java.util.*; // only one layer  we need the next line
import java.util.Map.Entry;

public class SingleNumber2 {
	//linear complexity means O(n)
	public static int singleNumber(int[] A) {
		
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        Map.Entry<Integer, Integer>  me;
        for(int i=0;i<A.length;i++){

        	if(h1.get(A[i])==null){
        		h1.put(A[i],1);
        	}
        	else
        	{
        		int val=h1.get(A[i])+1;
        		h1.put(A[i], val);
        	}
        	
        }
         
//        Set<Integer> s1= h1.keySet();
//        Iterator<Integer> itrs1=s1.iterator();
          
          Iterator<Entry<Integer, Integer>> itr=h1.entrySet().iterator(); //Map Iteration 
          while(itr.hasNext()){
        	   me =itr.next();
        	  if(me.getValue()==1){
        		  return me.getKey();
        	  }
//        	  itr.remove();
          }
          return 0;
          
        
    }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,1,2,2,2,3,4,3,3};
		int a;
		a= singleNumber(A);
		System.out.println(a);
	}

}
