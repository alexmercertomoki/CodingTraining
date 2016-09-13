package com.cmu.calculates1;

import java.util.Random;





public class TestArithmetic {
	
	static Random r = new Random();
	
	public static void main(String[] args) {
		int i=0;
		do{
		TestArithmetic t=new TestArithmetic();
		Node n = t.ChooseMethod(t.ChooseMethod(t.RConsts(),t.RConsts()),t.ChooseMethod(t.RConsts(),t.RConsts()));
		t.ShowResult(n);
		i++;
		}
		while(i<=4);
		
	}
	
	public Node RConsts() {
		int con = (int) (Math.random()*20 + 1); // generate constant integers randomly in the range from 1 to 20
		return new Const(con);
	}
	
	public Binop ChooseMethod(Node left, Node right) {
		int aSwi = r.nextInt(4);
		if(aSwi==0)
			return new Plus( left, right);
		if(aSwi==1)
			return new Minus(left, right);
		if(aSwi==2)
			return new Multiply(left,  right);
		if(aSwi==3)
			return new Division(left, right);
		else 
			System.out.println("it's impossible haha!^^");
		    return null;
		}
	
     public void ShowResult(Node n) {
		//System.out.println(r.nextInt()); 任意一个 全范围中的int
		System.out.print(n.toString() + " = ");
		System.out.printf( "%.2f\n", n.eval() );	
		
	 }
}
	

