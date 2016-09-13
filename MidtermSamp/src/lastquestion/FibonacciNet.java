package lastquestion;

public  class FibonacciNet {   
    
    /*输出斐波那契数*/  
    public static void printFibonacciNumber(long f1,long f2,int n){//the first number, the second number,the totel fibonacci numbers   
        for(int i = 1;i <= n;i++){   
            System.out.print(f1+" "+f2+" ");//先输出前两个数   
            if(i % 5 == 0)System.out.print("\n"); //换行  
            f1 = f1+f2;   //计算下两个数  ,one time print out two !! cool!  
            f2 = f1+f2;   
        }   
           
        /*后数除前数为黄金分割点*/  
        System.out.print("\n"+"-------------------------------------"+"\n");   
        System.out.println((double)f2/f1);//越到后边，后数除前数越接近黄金分割点   
           
           
    }   
       
    /*输出斐波那契数组*/  
    public static void printFibonacciArray(long f1,long f2,int n){//the first number, the second number,the totel fibonacci numbers   
        long f[] = new long[n];   
        f[0]=f1;   
        f[1]=f2;   
        for(int i =2;i <n;i++){ 
            f[i]=f[i-2]+f[i-1]; //数组的第三个数开始为前两个数的和  
        }   
        System.out.println("-------------------------------------"+"\n");   
        System.out.println(java.util.Arrays.toString(f)); //把数组转化成String输出  
           
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