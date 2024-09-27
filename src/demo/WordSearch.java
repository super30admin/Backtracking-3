package demo;


//Time Complexity : O(n*m)
//Space Complexity : O(n*m)
//Did this code successfully run on Leetcode :no
//Any problem you faced while coding this : tried with a boolean visited boolean array , making visited grids false. But the amswer is not as expected
public class WordSearch {

	
	    int n;
	    int m;
	    
	    boolean[][] visited ;
	    public boolean exist(char[][] board, String word) {
	        n = board.length;
	        m = board[0].length;  
	        visited = new boolean[n][m];
	        boolean flag = false;
	        for(int i=0; i < n; i++){
	            for(int j=0 ; j < m; j++){
	                if(word.charAt(i) == board[i][j] && helper(board, word, i,j,0)){
	                    
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    
	    private boolean helper(char[][] board, String word, int i , int j ,int index){
	        
	        if(i <0 || j <0 || i >= n || j >= m || board[i][j] != word.charAt(index) || visited[i][j] == false) {
	            return false;
	        }
	        
	        int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
	        
	        for(int [] dir : dirs){
	            
	            int r = i + dir[0];
	            int c = j + dir[1];
	            helper(board, word, r,c , index+1);
	        }
	        
	        visited[i][j] = false;
	        return false;
	        
	    }
	}

