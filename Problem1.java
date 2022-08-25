// Time Complexity : O(N!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    
    
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0, n);
        return result;
        
    }
    
    private void backtrack(boolean[][] board, int r, int n) {
        
        // base
        if(r == board.length) {
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i ++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        
        // logic
        for(int j = 0; j < board.length; j++) {
            if(isSafe(board, r, j)) {
                // action
                board[r][j] = true;
                // recurse
                backtrack(board, r + 1, n);
                // backtrack
                // whatever action was taken at that cell needs to be reversed as we are backtracking
                board[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c) {
            int n = board.length;
            // column up
            for(int i = 0; i <= r; i++) {
                if(board[i][c]) return false;
            }
            
            int i = r;
            int j = c;
            // diagonal up right
            while(i >= 0 && j < n) {
                if(board[i--][j++]) return false;
            }
            
            i = r;
            j = c;
            // diagonal up left
            while(i >= 0 && j >= 0) {
                if(board[i--][j--]) return false;
            }
            
            return true;
        }
}