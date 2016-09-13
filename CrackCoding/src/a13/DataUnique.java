package a13;

public class DataUnique {
	
	
	public boolean uniqueString(String str){
		boolean[] char_set=new boolean[256];
		for(int i=0;i<str.length();i++){
			int val=str.charAt(i); // get i's character's acsii if int           if char it's the character
			while(char_set[val]){
				System.out.println(char_set[val]);
				return false;
			}
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a;
        String str =new String();
        str="hello worrrrrrrrrrrrrrrrrld!";
        DataUnique du = new DataUnique();
        a=du.uniqueString(str);
        System.out.println(a);
        
	}
	
	
}
