package a12self;


public class DataUnique {
	
	
	public boolean uniqueString(String str){
		int a=0;
		boolean[] char_set=new boolean[256];
		for(int i=0;i<str.length();i++){
			int val=str.charAt(i); // get i's character  's acsii if int      if char it's the character
			if(char_set[val])
			{
				a++;
				char_set[val]=false;
				
			}
			else if(a==2){
				
				return false;
				
			}
			
			else
			char_set[val] = true;
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a;
        String str =new String();
        str="heo worrld!";
        DataUnique du = new DataUnique();
        a=du.uniqueString(str);
        System.out.println(a);
        
	}
	
	
}