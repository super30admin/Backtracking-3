/*

Approach: Backtracking is used row by row, trying to place one 
queen in each column of the current row only if it is 
safe with respect to previously placed queens.

The isValid method checks vertical and diagonal conflicts 
above the current cell, and if valid, the queen is placed, 
recursion proceeds to the next row, and then it backtracks 
by removing the queen.

 */

// Time: O(n.n! + nsqr) --> backtracking + recursion
// Space: O(nsqr) + O(n) --> nsqr for board, n for stack space

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);

        return result;
    }

    private void helper(boolean[][] board, int row, int n) {

        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }

                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }


        for(int j=0; j<n; j++) {
            if(isValid(board, row, j ,n)){
                // action
                board[row][j] = true;
                // recurse
                helper(board, row+1, n);
                // backtrack
                board[row][j] = false;
            }
        }     
    }

    private boolean isValid(boolean[][] board, int i, int j, int n) {
        int r = i, c = j;
        // straight above
        while(r >= 0) {
            if(board[r][c]) return false;
            r--;
        }

        r = i; c = j;
        // diagonal left up
        while(r>=0 && c >= 0) {
            if(board[r][c]) return false;
            r--; c--;
        }

        r = i; c = j;
        // diagonal right up
        while(r>=0 && c < n) {
            if(board[r][c]) return false;
            r--; c++;
        }

        return true;
    }
}