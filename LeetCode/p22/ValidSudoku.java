package p22;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	 public static boolean isValidSudoku(char[][] board) {
			 for(int i=0;i<9;i++){
			    if(linerowValid(board,i,0,i,8)==false){ //00---08,10---18,20---28~~
			    	return false;
			    }
			    if(linerowValid(board,0,i,8,i)==false){
			    	return false;
			    }
			    
			}
		    for(int i=0;i<3;i++){   // from left to right 9 by 9 by 9
		    	for(int j=0;j<3;j++){
		    		if(!linerowValid(board,i*3,j*3,i*3+2,j*3+2)){
		    			return false;
		    		}
		    	}
		    }
		    return true;
		    
		}
	 
	 private static boolean linerowValid(char[][] bd, int x1, int y1,int x2,int y2){
		 
		  Set<Character> st=new HashSet<Character>();
		  
		  for(int i=x1; i<=x2;i++){
			  for(int j=y1;j<=y2;j++){
				  if( bd[i][j]!='.'){
					 if(st.add(bd[i][j])==false){
						return false;
					 }
				  }
				
			  }
		  }
		  
		return true;
		   
	  }
	
	public static void main(String args[]){
//		char[][] sudoku={{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},
//				{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.',5,'.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
	
		char[][] sudoku={{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
		
		boolean a= isValidSudoku(sudoku);
		System.out.println(a);
		
		
	}
	

}
