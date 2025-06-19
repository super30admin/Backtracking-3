import java.util.*;

// Time Complexity : O(n!) where n is the number of queens
// Space Complexity : O(n^2) for the board and the result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class NQueens {
    List<List<String>> result;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return result;
    }

    private void backtrack(boolean[][] board, int r) {
        // base
        if (r == n) {
            List<String> li = new ArrayList<>();
            // convert the board to a list of strings
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) { // we have a Queen
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());

            }
            // add the list to the result
            result.add(li);
        }

        // logic
        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c)) {
                // action
                boolean temp = board[r][c];
                board[r][c] = true;
                // recurse
                backtrack(board, r + 1);
                // backtrack
                board[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        int i = r - 1; // remember to check from one level up
        int j = c;

        // check col
        while (i >= 0) {
            if (board[i][c])
                return false;
            i--;
        }
        // check left diagonal
        i = r; // reset
        j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }

        i = r; // reset
        j = c;
        // check right diagonal
        while (i >= 0 && j < n) {
            if (board[i][j])
                return false;
            i--;
            j++;
        }

        return true;
    }
}
