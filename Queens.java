import java.util.ArrayList;
import java.util.List;

public class Queens {
    // TC O(N!) - Each row has n-2 options to place the queen
    // SC O(N^2)
    class Solution {
        List<List<String>> res;
        boolean[][] board;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            board = new boolean[n][n];
            helper(n, 0);
            return res;
        }

        private void helper(int n, int row) {
            if (row == n) {
                List<String> temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {

                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (board[i][j]) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    temp.add(sb.toString());
                }
                res.add(temp);
                return;
            }

            for (int j = 0; j < n; j++) {
                if (isValidPosition(row, j, n)) {
                    board[row][j] = true;
                    helper(n, row + 1);
                    board[row][j] = false;
                }
            }
        }

        private boolean isValidPosition(int row, int col, int n) {

            for (int i = row; i >= 0; i--) {
                if (board[i][col]) {
                    return false;
                }
            }

            int i = row;
            int j = col;
            while (i >= 0 && j >= 0) {
                if (board[i][j]) {
                    return false;
                }
                i--;
                j--;
            }

            i = row;
            j = col;
            while (i >= 0 && j < n) {
                if (board[i][j]) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }
}
