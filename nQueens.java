import java.util.*;

class Solution {
    // Tc: O(n!) Sc: O(n^2)
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        if (n == 0)
            return ans;

        boolean[][] board = new boolean[n][n];
        backtrack(board, 0, n);

        return ans;
    }

    private void backtrack(boolean[][] board, int r, int n) {

        if (r == n) {
            List<String> li = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(sb.toString());
            }

            ans.add(li);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c, n)) {
                board[r][c] = true;
                backtrack(board, r + 1, n);
                board[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c, int n) {
        // Column Up
        for (int i = 0; i < r; i++) {
            if (board[i][c])
                return false;
        }

        // diagonal up right
        int i = r;
        int j = c;
        while (i >= 0 && j < n) {
            if (board[i][j])
                return false;
            i--;
            j++;
        }

        // diagonal up left

        i = r;
        j = c;

        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }
        return true;
    }
}