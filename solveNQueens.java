// Time Complexity : O(n!) 
// Space Complexity : O(n^2) 
/*Approach : we use a backtracking approach where we place queens one row at a time, ensuring that each queen is placed in a safe position
 (no two queens threaten each other). We use a helper function to recursively try placing a queen in each column of the current row, 
 checking for safety in the column and both diagonals. If a valid position is found, we place the queen and move to the next row. 
 If all rows are successfully processed, we add the board configuration to the result. If not, we backtrack by removing the queen 
 and trying the next position. This process continues until all possible solutions are found.
 */
class Solution {
    // List to store the final result of all possible solutions
    List<List<String>> result = new ArrayList<>();

    // Main method to solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        // Initialize the board with all positions set to false (no queens placed)
        boolean[][] board = new boolean[n][n];
        // Start the recursive helper function from the first row
        helper(board, 0, n);
        return result;
    }

    // Recursive helper function to place queens on the board
    private void helper(boolean[][] board, int r, int n) {
        // Base case: if all rows are processed, add the board configuration to the result
        if (r == n) {
            List<String> sList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                sList.add(sb.toString());
            }
            result.add(sList);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int c = 0; c < n; c++) {
            // Check if it's safe to place a queen at board[r][c]
            if (isSafe(board, r, c, n)) {
                // Place the queen
                board[r][c] = true;
                // Recur to place queens in the next row
                helper(board, r + 1, n);
                // Backtrack and remove the queen
                board[r][c] = false;
            }
        }
    }

    // Function to check if it's safe to place a queen at board[r][c]
    private boolean isSafe(boolean[][] board, int r, int c, int n) {
        // Check the column for another queen
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c]) return false;
        }
        // Check the upper left diagonal for another queen
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false;
            i--;
            j--;
        }
        // Check the upper right diagonal for another queen
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < n) {
            if (board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
