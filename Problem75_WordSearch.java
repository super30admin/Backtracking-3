// Time Complexity : O(m*n*3^L), where L = length of the string
// Space Complexity : O(L), where L = length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int r, int c, int index) {
        // base
        if(index == word.length())
            return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;
        // logic
        if(board[r][c] == word.charAt(index)) {
            char ch = word.charAt(index);
            board[r][c] = '#';
            for(int[] dir : dirs) {
                int row = dir[0] + r;
                int col = dir[1] + c;
                if(helper(board, word, row, col, index + 1))
                    return true;
            }
            // backtrack
            board[r][c] = ch;
        }
        return false;
    }
}