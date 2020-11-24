//Time Complexity : O(3^(word length))
//Space Complexity : O(word length)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Word_Search_79 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(dfsBacktrack(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    private boolean dfsBacktrack(char[][] board, String word, int i, int j, int index)
    {
        // Base case
        if(index == word.length())
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*')
            return false;
        // Logic
        // Action
        if(word.charAt(index) == board[i][j])
        {
            char ch = board[i][j];
            board[i][j] = '*';
            // Recurse
            for(int[] dir : dirs)
            {
                int row = i + dir[0];
                int col = j + dir[1];
                if(dfsBacktrack(board, word, row, col, index+1))
                    return true;
            }
            board[i][j] = ch;
        }
       return false;     
    }
}
