// Time Complexity : O(m*n*4^l); m -> no.of rows in board; n -> no. of columns in board; l -> length of word
// Space Complexity : O(l); l no. of possible elements in recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : 
// We can iterate over the board to find the first matching character. Once we get the starting point, we can perform a depth first search considering all 4 directions on the board.

class Solution {
    public boolean exist(char[][] board, String word) {
        // edge case
        if(board == null || board.length == 0 || word.length() == 0) return false;
        
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[0].length; y++) {
                if(board[x][y] == word.charAt(0)) {
                        if(dfs(board, word, x, y)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j) {
        // base case
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(0))
            return false;
        if(board[i][j] == word.charAt(0) && word.length() == 1)
            return true;
        
        //logic
        char temp = board[i][j];
        board[i][j] = ' ';
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : dirs) {
            if(dfs(board, word.substring(1), i+dir[0], j+dir[1])) {
                return true;
            }
                
        }
        board[i][j] = temp; // backtrack if word not found by considering any of the 4 directions
        return false;
    }
}

