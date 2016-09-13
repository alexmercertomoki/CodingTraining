package p6;

public class Y1{
  
	public static void main(String args[]){
		  double[] a =new double[3];
		 try{
			 
			a[4]=1;
		 }
		 catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Hey it is ok");
		 }
	}
	
	

}
