package backtracking3;

public class WordSearch {
	// dfs
	//Time Complexity : O(m*n*3^L), where m are rows, n are columns and L is the length of string word
	//Space Complexity : O(L), where L is the length of string word
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, i, j, 0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int idx) {
        // base
        if(idx == word.length())
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(idx))
            return false;
        
        // logic
        char ch = board[i][j];
        board[i][j] = '#';
        if(helper(board, word, i, j + 1, idx + 1) ||
           helper(board, word, i + 1, j, idx + 1) ||
           helper(board, word, i, j - 1, idx + 1) ||
           helper(board, word, i - 1, j, idx + 1))
            return true;
        
        board[i][j] = ch;
        return false;
    }
}
