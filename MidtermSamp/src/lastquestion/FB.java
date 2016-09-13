package lastquestion;

public class FB {
	public static  int k=0;
	public static void fb(int i, int j,int n){
		
		k++;
		System.out.println(i + j);	
		if(k>n)
			System.exit(0);
		fb(j, i + j,n);
		
	
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fb(1,2,10);
	}

}
