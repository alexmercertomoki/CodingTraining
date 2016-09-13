package lastquestion;

public class CopyOfFibonacci {
	//int i;
	  class Fibo{
		//long f[] = new long[10];
		
		
	//	int i[]={1,2};
		
		Fibo(int k){ //why static ?
			
			int[] i=new int[2];
			i[0]=1;   // why cant I do this ~~  only do it when in the method.
		    i[1]=2;
		    
			System.out.println(i[0]+"\n"+i[1]);
			for(int j=1;j<=k;j++)
			{
				if(j%2!=0){
					i[0]=i[1]+i[0];
					 System.out.println(i[0]);
				}
				if(j%2==0){
					 i[1]=i[1]+i[0];
					 System.out.println(i[1]);
				}
			 
			}
			
			
		}
	   
	}
	
	public  static void main(String[] args){
	// public static void main(String[] args)	
		CopyOfFibonacci c =  new CopyOfFibonacci();
		
	}

}
