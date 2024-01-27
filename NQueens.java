import java.util.*;

public class NQueens {
    // TC: O(N!)
    // SC: O(N * N)
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        backtrack(res, board, n, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, boolean[][] board, int n, int row) {
        if (row == n) {
            List<String> currRes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                currRes.add(sb.toString());
            }
            res.add(new ArrayList<>(currRes));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = true;
                backtrack(res, board, n, row + 1);
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col, int n) {
        int i = row, j = col;
        while (i >= 0) {
            if (board[i][col]) return false;
            i--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j]) return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
}
