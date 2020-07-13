// Time Complexity : O(N.4^L) where L is length of the word
// Space Complexity : O(L) 
// Did this code successfully run on Leetcode : yes		
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    int m;
    int n;
    
    StringBuilder sb;
    public boolean exist(char[][] board, String word) {
        
        
         m = board.length;
         n = board[0].length;
         sb = new StringBuilder("");
        for(int i = 0 ; i < m; i++){
            for(int j =0 ; j < n; j++){
                if(helper(board,i,j,0,word)) return true;
            }
        }
        
        return false;
        
    }
    
    private boolean helper(char[][] board , int i , int j, int index, String word){
        
        //base
        if( i < 0 || j < 0 || i >= m || j >= n || board[i][j] =='#' || board[i][j]!= word.charAt(index))
            return false;
        
        if(index == word.length() -1 )
            return true;
        
        char temp = board[i][j];
       // sb.append(board[i][j]);
        board[i][j] = '#';
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs){
            int r = dir[0] +i;
            int c = dir[1]+ j;
      
            if( helper(board, r , c , index+1, word))
                return true;
        }  
       
        board[i][j] = temp;
    
        return false;
      
        
        
    }
}