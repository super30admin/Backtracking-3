// Time Complexity : O(N*3^L) L - length(word)
// Space Complexity : O(L)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++)
            for(int j=0; j<board[0].length; j++)
                if(board[i][j]==word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int index, String word) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(index))
            return false;
        
        if(index == word.length()-1)
            return true;
        
      // save the curr character 
        char temp = board[i][j];
      // mask the curr character with a different character
        board[i][j] = ' ';
        
        boolean found = dfs(board, i+1, j, index+1, word) ||
                        dfs(board, i-1, j, index+1, word) ||
                        dfs(board, i, j+1, index+1, word) ||
                        dfs(board, i, j-1, index+1, word);
        
      // unmask the curr character and replace it with the old character 
        board[i][j] = temp;
        
        return found;
    }
}
