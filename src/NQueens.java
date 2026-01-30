import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private List<List<String>> solutions;

    /*
     * Time Complexity:
     * - Each placement calls isValid() which scans up to O(n) vertically and diagonally -> O(n)
     * - Rough upper bound: O(n! * n)
     * Space Complexity:
     * - O(n^2) for the board + O(n) recursion depth
     */
    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        boolean[][] board = new boolean[n][n]; // true means a queen is placed
        backtrack(board, 0, n);
        return solutions;
    }

    /*
    Place a queen in one row and recursively slow the other rows
     */
    private void backtrack(boolean[][] board, int row, int n) {
        // Base case: if we've placed queens in all rows, we found a valid solution
        if (row == n) {
            solutions.add(buildSolution(board, n));
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                // Choose
                board[row][col] = true;

                // Explore
                backtrack(board, row + 1, n);

                // Un-choose (backtrack)
                board[row][col] = false;
            }
        }
    }

    /*
    Converts the boolean board into the required List<String> representation
     */
    private List<String> buildSolution(boolean[][] board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            list.add(sb.toString());
        }
        return list;
    }

    /*
     * Checks if placing a queen at (row, col) is safe.
     * Since we place queens row-by-row from top to bottom, we only need to check:
     *  1) same column above
     *  2) upper-left diagonal
     *  3) upper-right diagonal
     */
    private boolean isValid(boolean[][] board, int row, int col, int n) {
        //Check same column (above rows)
        for (int r = row; r >= 0; r--) {
            if (board[r][col]) return false;
        }

        // Check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        // Check upper-right diagonal
        for (int r = row, c = col; r >= 0 && c < n; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }

    // Test
    public static void main(String[] args) {
        NQueens solver = new NQueens();

        int n = 4;
        List<List<String>> res = solver.solveNQueens(n);

        System.out.println("n = " + n);
        System.out.println("Number of solutions: " + res.size());
        System.out.println();

        // Print all solutions
        int solNum = 1;
        for (List<String> sol : res) {
            System.out.println("Solution " + solNum++ + ":");
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
