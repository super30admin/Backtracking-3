import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueens(board, 0, n);
        return solutions;
    }

    public boolean placeQueens(int[][] board, int row, int n) {
        // Base case
        if (row == n) {
            List<String> currentSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder rowString = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1)
                        rowString.append('Q');
                    else
                        rowString.append('.');
                }
                currentSolution.add(rowString.toString());
            }
            solutions.add(currentSolution);
            return false;
        }

        // Recursive case
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (placeQueens(board, row + 1, n))
                    return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(int[][] board, int row, int col, int n) {
        // Check same column
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 1) {
                return false;
            }
        }

        // Check left diagonal
        int x = row - 1;
        int y = col - 1;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1)
                return false;
            x--;
            y--;
        }

        // Check right diagonal
        x = row - 1;
        y = col + 1;
        while (x >= 0 && y < n) {
            if (board[x][y] == 1)
                return false;
            x--;
            y++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        List<List<String>> result = solver.solveNQueens(4);
        System.out.println(result); // [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
    }
}
