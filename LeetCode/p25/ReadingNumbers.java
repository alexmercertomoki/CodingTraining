package p25;

public class ReadingNumbers {

	public static String countAndSay(int n) {
		 if(n==1){
			 return "1";
		 }
		 StringBuilder sb=new StringBuilder();
		 
		 String last = countAndSay(n - 1);
		 char lastA = last.charAt(0);
		 int count=0;
		 int lenS = last.length();
		 for(int i=0;i<lenS;i++){
			 if(lastA == last.charAt(i)){
		            count++;
		        }
			 else{
		            sb.append(count);
		            sb.append(lastA);
		            lastA = last.charAt(i);
		            count = 1;
		        }
			
		 }
		 
		 sb.append(count);
		 sb.append(lastA);
	     return sb.toString();
		 
    }

	
	   
	public static void main(String[] args) {
		
		int n=2;
		String str=countAndSay(n);
		System.out.println(str);
		

	}

}
