// Time Complexity : O(n!)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use backtracking to solve this
// We first put the queen in one position in the board and then we check if we can put the other queens with the first queen placed
// Before placing the other queens we chack the upper diagonal left and upper diagonal right and in the same column

class Solution {
    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n == 0)
            return result;
        board = new boolean[n][n];
        backtrack(0);
        return result;

    }

    public void backtrack(int row) {
        if (row == board.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == true)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(row, j)) {
                board[row][j] = true;
                backtrack(row + 1);
                board[row][j] = false;
            }
        }
    }

    public boolean isSafe(int r, int c) {
        for (int i = r; i >= 0; i--) {
            if (board[i][c] == true)
                return false;
        }
        int i = r, j = c;
        while (j >= 0 && i >= 0) {
            if (board[i][j] == true)
                return false;
            i--;
            j--;
        }
        i = r;
        j = c;
        while (j < board.length && i >= 0) {
            if (board[i][j] == true)
                return false;
            i--;
            j++;
        }
        return true;
    }
}