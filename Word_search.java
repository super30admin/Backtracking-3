// Time Complexity : m*n 4^n m*n is the size of matrix and at each point we have 4 choices to make.
// Space Complexity : O(n) where n is the length of the string to be searched(Recursive stack space).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0)
            return true;
        
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(backtracking_dfs(board,word,i,j)) return true;  //Call DFS for each char in the board.
                                                // Backtracking function will handle if there is continuty of chars from the words to be searched. 
                // We should not give 'return backtracking_dfs(board,word,i,j)' because we will recive true only when all the char in strings are avaialble in sequence. Most of the case it will return false and we should continue with next char rather than stoping or terminating the loop.
            }
        }
        
        return false;
    }
    
    private boolean backtracking_dfs(char[][] board, String word, int i, int j){
        
        // Base
        if(i < 0 || i>= board.length || j< 0 || j>= board[0].length || board[i][j] == '#')
            return false;
        
        //logic
        int[][] dirs  = {{0,1},{1,0},{-1,0},{0,-1}};
        
        if(board[i][j] == word.charAt(0)){
            if(word.length() == 1) return true;
            char prev = board[i][j];
            board[i][j] ='#';  // Update the visited elements with # symbol.
        
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(backtracking_dfs(board, word.substring(1), r, c)) return true;
         }
            board[i][j] =prev;
        }
           return false; 
        }
}
