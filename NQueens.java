import java.util.ArrayList;

// Time Complexity : O(N!+N) = O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes
// Your code here along with comments explaining your approach: check valid places to put queen in a row, and backtrack if remaining queens cannot be placed on the board

public class NQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, 0);
        return res;
    }

    public boolean placeQueens(int[][] board, int r) {

        int n = board.length;
        // base case
        if (r == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String a = new String();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1)
                        a += 'Q';
                    else
                        a += '.';
                }
                temp.add(a);
            }
            res.add(temp);
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, r, i)) {
                board[r][i] = 1;
                if (placeQueens(board, r + 1)) {
                    return true;
                }
            }
            board[r][i] = 0;
        }
        return false;
    }

    public boolean isSafe(int[][] board, int r, int i) {
        int n = board.length;
        // col check
        for (int j = 0; j < r; j++) {
            if (board[j][i] == 1) {
                return false;
            }
        }
        int x = r - 1;
        int y = i - 1;

        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1)
                return false;
            x--;
            y--;
        }
        // right diagonal
        x = r - 1;
        y = i + 1;

        while (x >= 0 && y < n) {
            if (board[x][y] == 1)
                return false;
            x--;
            y++;
        }
        return true;
    }
}
