// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        this.board = new boolean[n][n];
        backtrack(0);
        return result;
    }
    private void backtrack(int r) {
        // base case
        if(r == board.length) {
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j] == true) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        
        // logic
        for(int j = 0; j < board.length; j++) {
            if(isSafe(r, j)) {
                // action
                board[r][j] = true;
                // recurse 
                backtrack(r + 1);
                // backtrack
                board[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        // column check
        for(int i = 0; i < row; i++) {
            if(board[i][col] == true)
                return false;
        }
        
        // diagonal up left
        int i = row;
        int j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == true)
                return false;
            i--;
            j--;
        }
        
        // diagonal up right
        i = row;
        j = col;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == true)
                return false;
            i--;
            j++;
        }
        return true;
    }
}