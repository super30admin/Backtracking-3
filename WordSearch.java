package s30Coding;

//Time Complexity :- O(n* 4^L) where L is the length of the string and n is the number of cells in the board
//Space Complexity :- O(L)

//LeetCode :- Yes

public class WordSearch {
	 int m ;  
	    int n;
	    
	    public boolean exist(char[][] board, String word) {
	        if(board == null || board.length == 0) return false;
	        m = board.length; n = board[0].length;
	        for(int i = 0; i < m ; i++){
	            for(int j = 0; i < n ;j++){
	                if(backtrack(board,word, i, j)) return true;
	            }
	        }
	        return false;
	    }
	    private boolean backtrack(char[][] board, String word, int i, int j){
	        if(word.length() == 0) return true;
	        if(i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] == '#') return false;
	        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
	        if(board[i][j] == word.charAt(0)){
	            char prev = board[i][j];
	            board[i][j] = '#';
	            for(int[] dir : dirs){
	                int r = dir[0] + i;
	                int c = dir[1] + j;
	                if(backtrack(board,word.substring(1), r , c)){
	                    return true;
	                }
	            }
	            board[i][j] = prev;
	        }
	        return false;
	    }
}
