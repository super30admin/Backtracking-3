// Time Complexity : O(mn3^k)
// Space Complexity : O(l) where l is the length of the word to be matched
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(backtrack(board, word, 0, i, j, m, n)) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int idx, int r, int c, int m, int n) {
        
        // base
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;
        
        // logic
        if(board[r][c] == word.charAt(idx)) {
            // action
            char ogChar = board[r][c];
            board[r][c] = '#';
            // recurse
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, idx + 1, nr, nc, m, n)) return true;
            }
            // backtrack
            board[r][c] = ogChar;
        }
        return false;
    }
}