import java.util.*;

// Approach: Backtrack using a boolean matrix to store queen's' place state of board
// if it is safe to place a queen and use a StringBuilder to
// create required string in the base case
// Time: O(N!) where N is the No. of Queens
// Space: O(N^2) to store state of boards
public class N_Queens {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int r, int n) {

        List<String> li = new ArrayList();
        // base case
        if (r == n) {
            for (int i = 0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j<n; j++) {
                    if (board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        // logic
        for (int j = 0; j<n; j++) {
            if (isSafe(r, j, n)) {
                // action
                board[r][j] = true;
                // recurse
                helper(r+1, n);
                // backtrack
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c, int n) {
        // column up
        for (int i = r-1; i>=0; i--) {
            if (board[i][c]) return false;
        }
        // diagonal right up
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) return false;
        }
        // diagonal left up
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        return true;
    }
}
