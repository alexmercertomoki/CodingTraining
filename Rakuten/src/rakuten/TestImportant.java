package rakuten;

public class TestImportant {
	public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 8
		int a1,b1,a2,b2;
		a1=M-K;
		b1=N-L;
		
		a2=R-P;
		b2=S-Q;
		int x1,x2,y1,y2;
		int InterArea;
		
		if(M<P||K>R||L>S||Q>N){
			return a1*b1+a2*b2;
		}
		if(N<=S){
			y1=N;
		}else{
			y1=S;
		}
		if(L>=Q){
			y2=L;
		}else{
			y2=Q;
		}
		if(M<=R){
			x1=M;
		}else{
			x1=R;
		}
		if(K>=P){
			x2=K;
		}else{
			x2=P;
		}
		InterArea=(x2-x1)*(y2-y1);
		
//		System.out.println(InterArea);
//		return -1;
		
		return a1*b1+a2*b2-InterArea;
		
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int 
		int   K = -4  , L = 1   ,   M = 2 ,    N = 6 ,   
			 P = 0  ,   Q = -1 ,    R = 4   ,  S = 3;
		
		System.out.println(solution(0,0,10,10,10,10,20,20));
		
		solution(-4,1,2,6,0,-1,4,3);
//		0,0,100,100,45,45,50,50
		
		
		
	}

}
