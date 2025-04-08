// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// for loop based recursive
// TC = O(n!) at each level, the choice of putting Q becomes, n -> n-2 -> n-4 ... ie eqvlnt to n!
// SC = O(n^2) size of boolean board
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        // null
        if(n == 0) return result;
        boolean[][] board = new boolean[n][n];// SC=O(n^2), boolean as its most efficient DS
        backtrack(board, 0, n); // SC = O(N) ie of Height but n^2 above is the relevant term
        return result;
    }
    public void backtrack(boolean[][] board, int r, int n) {
        // base
        if(r == n) {
            List<String> li = new ArrayList<>(); // convert boolean to string for result
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // logic
        for(int j = 0; j < n; j++) { // j as column
            if(isSafe(board, r, j, n)) {
                board[r][j] = true; // action
                backtrack(board, r + 1, n); // recurse
                board[r][j] = false; // backtrack
            }
        }
    }
    private boolean isSafe(boolean[][] board, int r, int c, int n) {
        // up col
        for(int i = 0; i < r; i++) {
            if(board[i][c]) return false; // Queen found, cant place
        }
        // up left diagonal, r--, c--
        int i = r, j = c; // dont modify r & c
        while(i >= 0 && j >= 0) {
            if(board[i--][j--]) return false; // Queen found, cant place
        }
        // up right diagonal
        i = r; j = c; // resetting i & j
        while(i >= 0 && j < n) {
            if(board[i--][j++]) return false; // Queen found, cant place
        }
        return true;
    }
}