//Time Complexity : O(MN * 3^L) MN is the board row and column (because we traverse whole board),and L is the word length 
//Space Complexity :O(L) recursive stack space 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :

public class WordSearch {
	  	boolean result;
	    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	    int  m,n;
	    public boolean exist(char[][] board, String word) {
	     
	        result = false;
	        m = board.length;
	        n = board[0].length;
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(board[i][j]==word.charAt(0)){
	                         helper(board,i,j,word,0);
	                }
	            }
	        }     
	        
	       return result;
	    }
	    
	    public void helper(char[][] board,int r,int c, String word,int idx){
	        // base case 
	        if(idx==word.length()){
	            result = true;
	            return;
	        }
	        if(r<0 || r==m || c<0 || c==n || 
	           board[r][c]=='#'){
	             return; 
	          }  

	    //logic 
	    // Action
	     if( board[r][c]==word.charAt(idx)){
	         char temp=board[r][c];
	         board[r][c]='#';  
	         // Recurse 
	         for(int[] dir : dirs){
	                int nr = dir[0]+r;
	                int nc = dir[1]+c;
	              helper(board,nr,nc,word,idx+1);
	            }
	         // backtrack   
	            board[r][c]=temp;  
	         }   
	     
	    }
	    
}
