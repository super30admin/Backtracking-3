import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return res;
    }

    public void backtrack(boolean[][] board, int i) {

        // base case
        if (i == board.length) {
            List<String> li = new ArrayList<>();
            for (int r = 0; r < board.length; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < board.length; c++) {
                    if (board[r][c] == true)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }

        // logic
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, i, j)) {
                board[i][j] = true;
                backtrack(board, i + 1);
                board[i][j] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] board, int r, int c) {

        // column up
        for (int i = 0; i < r; i++)
            if (board[i][c] == true)
                return false;

        int i = r;
        int j = c;

        // diagonal left
        while (i >= 0 && j >= 0) {
            if (board[i][j])
                return false;
            i--;
            j--;
        }

        int m = r;
        int n = c;
        // diagonal right
        while (m >= 0 && n < board[0].length) {
            if (board[m][n])
                return false;
            m--;
            n++;
        }

        return true;
    }
}