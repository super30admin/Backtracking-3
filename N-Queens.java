// Time Complexity :O(N!)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only:Backtracking
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(result, board, n, 0);
        return result;
    }

    public static void solve(List<List<String>> result, char board[][], int n, int r) {
        if (n == r) {
            List<String> re = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                re.add(String.valueOf(board[i]));
            }
            result.add(re);
            return; // Return here to prevent unnecessary execution
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c, n)) {
                board[r][c] = 'Q';
                solve(result, board, n, r + 1);
                board[r][c] = '.';
            }
        }
    }

    public static boolean isSafe(char board[][], int r, int c, int n) {
        // Check for queens in the same column
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        // Check upper left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check upper right diagonal
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
