// Time Complexity : O(N*3^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class WordSearch {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        if(rows*cols<word.length())
            return false;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j]==word.charAt(0) && backtrack(board, word, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int charIndex) {
        //base
        if(charIndex == word.length())
            return true;
        
        if(i>=board.length ||i<0 || j>=board[0].length || j<0 || board[i][j]!=word.charAt(charIndex))
            return false;
        
        //logic
        board[i][j] = '#';
        
        boolean ret = (backtrack(board, word, i+1, j, charIndex+1) || 
                      backtrack(board, word, i-1, j, charIndex+1) ||
                      backtrack(board, word, i, j+1, charIndex+1) || 
                      backtrack(board, word, i, j-1, charIndex+1));
        
        board[i][j] = word.charAt(charIndex);
        
        return ret;
    }
}
