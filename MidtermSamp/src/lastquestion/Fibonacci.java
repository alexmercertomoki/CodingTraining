package lastquestion;

public class Fibonacci {
	//int i;
	static class Fibo{  // 斐波那契的别的实现方法n+1
		//long f[] = new long[10];
//		int i[]=new int[2];
//		i[0]=1;   // why cant I do this ?? question n
//		i[1]=2;
		
		int i[]={1,2};
		
		Fibo(int k){
			System.out.println(i[0]+"\n"+i[1]);
			for(int j=1;j<=k;j++)
			{   // we can use j to \n
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
	    Fibo f=new Fibo(10);
	}

}
