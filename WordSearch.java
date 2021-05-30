// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(4 power n) since we can move four directions while searching the charecters that are being searched exponentially
//Space Complexity: O(n) 
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length; int n = board[0].length;
        if(word.length() == 0) return true;
        if(board == null || board.length == 0) return false;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, i, j, 0)){
                        return true;
                    }    
                }
            }
        }        
        return false;
    }
    
    private int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private boolean backtrack(char[][] board, String word, int i, int j, int index)
    {
        //base case
        if(index == word.length() - 1) return true;       
        
        //logic 
        
            //action
            char temp = board[i][j];
            board[i][j] = '#';
        
            //recurse
            for(int[] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && word.charAt(index + 1) == board[r][c]){                 
                if(backtrack(board, word, r, c, index+1)) return true;   
                }
            }
        
            //backtrack
            board[i][j] = temp;            
        
        return false;
    }
}
