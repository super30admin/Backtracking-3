/*
Problem: https://leetcode.com/problems/word-search/
TC: O(m * n)
SC: O(word len)
*/
class Solution {
    int m, n;
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        
        m = board.length;
        n = board[0].length;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        //base
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index))
            return false;
        
        if (index == word.length() - 1) {
            return true;
        }
        
        // logic
        char ch = board[row][col];
        board[row][col] = '#';
        for (int d[] : dirs) {
            if (backtrack(board, row + d[0], col + d[1], word, index + 1)) {
                return true;
            }
        }
        board[row][col] = ch;
        return false;
    }
}