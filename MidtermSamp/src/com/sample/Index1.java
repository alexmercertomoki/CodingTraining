package com.sample;

public class Index1 {// index obligation
	int i=0;
	Obligations[] ob=new Obligations[20];
	private StringBuffer all = new StringBuffer();
	public void add(Obligations a){
		if(i>=19)
		{
			System.out.println("no more obligations");
			System.exit(0);
		}
		ob[i]= a;
		i++;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Obligations a=new Obligations("12-30-2014","To finish Java!");
		Index1 i1=new Index1();
		i1.add(a);
		System.out.println(i1);

	}
	public String toString(){//debug สนำร
		//all = "";
		
		for(int a = 0;a<i;a++){
		//	System.out.println(a);
		 all.append("Date:"+this.ob[a].date+"\nText:"+this.ob[a].text+"\n");
		}
		
		return all.toString();
		
	}

}
