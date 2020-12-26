// Time Complexity : exponential
// Space Complexity : O(length of word)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && exist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word, int i, int j, int pos) {
        
        if(pos == word.length())
            return true;
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(pos))
            return false;
        
        char ch = board[i][j];
        board[i][j] = '*';
       if(exist(board, word, i - 1, j, pos + 1) ||
        exist(board, word, i , j - 1, pos + 1) ||
        exist(board, word, i + 1, j, pos + 1) ||
        exist(board, word, i , j + 1, pos + 1))
           return true;
        
        board[i][j] = ch;
        
        return false;        
    }
    
}