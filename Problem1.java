// Time Complexity o(2^n) space complexity o(n^2)
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        result = new ArrayList<>();
        helper(board, 0, n);
        return result;
    }

    public void helper(boolean[][] board, int i, int n) {
        if (i == n) {
            List<String> li = new ArrayList<>();
            for (int i1 = 0; i1 < n; i1++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i1][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, i, j, n)) {
                board[i][j] = true;
                helper(board, i + 1, n);
                board[i][j] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] board, int r, int c, int n) {
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }
        int i = r;
        int j = c;
        while (i >= 0 && j < n) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        i = r;
        j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}