package Textjava;


import java.io.*;

public class TextTry {

	
	public static void main(String[] args) {
		// TODO �Զ����ɷ������
	 /* try{
		  System.out.println(2/0);
	  }
	  catch(ArithmeticException ae){
	    ae.printStackTrace();
	    System.out.println("something is wrong, try again..");
	  }
	  */
		/*
		int i;
		TextTry x=new TextTry();
		i=1;
		x.m(i);

	}
	void m (int i) throws ArithmeticException{
		if(i==1){
		    throw new ArithmeticException("������Ϊ1");
		}	
		*/	
		FileInputStream in=null;
		try{
			in=new FileInputStream("me.txt");
			int b=in.read();
			while(b != -1){
			   System.out.print((char)b);
			   b=in.read();
			}

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			try{
				in.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	
	}
	
	
}
