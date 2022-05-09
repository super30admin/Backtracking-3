// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0) return false;
        
        int m = board.length;
        int n = board[0].length;
        dirs = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            
        };
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    
    private boolean helper(char[][] board, String word, int index, int r, int c) {
        if(index == word.length()) {
            return true;
        }
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') return false;
        
        if(board[r][c] == word.charAt(index)) {
            char ch = board[r][c];
            // action
            board[r][c] = '#';
            
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(helper(board, word, index + 1, nr, nc)) return true;
            }
            board[r][c] = ch;
        }
        return false;
    }
}