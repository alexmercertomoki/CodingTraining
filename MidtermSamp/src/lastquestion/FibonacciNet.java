package lastquestion;

public  class FibonacciNet {   
    
    /*���쳲�������*/  
    public static void printFibonacciNumber(long f1,long f2,int n){//the first number, the second number,the totel fibonacci numbers   
        for(int i = 1;i <= n;i++){   
            System.out.print(f1+" "+f2+" ");//�����ǰ������   
            if(i % 5 == 0)System.out.print("\n"); //����  
            f1 = f1+f2;   //������������  ,one time print out two !! cool!  
            f2 = f1+f2;   
        }   
           
        /*������ǰ��Ϊ�ƽ�ָ��*/  
        System.out.print("\n"+"-------------------------------------"+"\n");   
        System.out.println((double)f2/f1);//Խ����ߣ�������ǰ��Խ�ӽ��ƽ�ָ��   
           
           
    }   
       
    /*���쳲���������*/  
    public static void printFibonacciArray(long f1,long f2,int n){//the first number, the second number,the totel fibonacci numbers   
        long f[] = new long[n];   
        f[0]=f1;   
        f[1]=f2;   
        for(int i =2;i <n;i++){ 
            f[i]=f[i-2]+f[i-1]; //����ĵ���������ʼΪǰ�������ĺ�  
        }   
        System.out.println("-------------------------------------"+"\n");   
        System.out.println(java.util.Arrays.toString(f)); //������ת����String���  
           
    }   
  
    /**  
     * main method  
     * @param args  
     */  
    
    public static void main(String[] args) {   
    	FibonacciNet.printFibonacciNumber(10, 11, 10);//print the 20 advanced fibonacci number   
    	FibonacciNet.printFibonacciArray(0, 1, 20);   
    }   
  
}