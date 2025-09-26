//Time Complexity: O(N!)
//Space Complexity: O(N^2)
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> output = new ArrayList<>();
        final boolean[][] grid = new boolean[n][n];
        if (n < 4) return output;

        backtrack(0, n, grid, output);
        return output;
    }

    private void backtrack(int row, int n, boolean[][] grid, List<List<String>> output) {
        //base
        if (row == n) {
            final List<String> combo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]) builder.append("Q");
                    else builder.append(".");
                }
                combo.add(builder.toString());
            }

            output.add(combo);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(grid, row, c, n)) {
                //action
                grid[row][c] = true;
                //recurse
                backtrack(row + 1, n, grid, output);
                //backtrack
                grid[row][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] grid, int row, int col, int n) {
        //column
        for (int i = 0; i < row; i++) {
            if (grid[i][col]) return false;
        }

        //left diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (grid[i--][j--]) return false;
        }

        //right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (grid[i--][j++]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        final NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
        System.out.println(nQueens.solveNQueens(5));
        System.out.println(nQueens.solveNQueens(9));
        System.out.println(nQueens.solveNQueens(3));
    }
}
