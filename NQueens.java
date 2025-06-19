// Time Complexity O(n ^ n)
// Space Complexity O(1)
// Runs on LeetCode YES

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, result, 0);
        return result;
    }

    private void backtrack(boolean[][] board, List<List<String>> result, int row) {
        if (row == board.length) {
            ArrayList<String> b = new ArrayList<String>();

            for (int r = 0; r < board.length; r++) {
                StringBuffer sb = new StringBuffer();

                for (int c = 0; c < board.length; c++) {
                    if (board[r][c] == true) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                b.add(sb.toString());
            }

            result.add(b);
        }

        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {
                // action
                board[row][j] = true;
                // recurse
                backtrack(board, result, row + 1);
                //backtrack
                board[row][j] = false;
            }

        }

    }

    private boolean isSafe(boolean[][] board, int r, int c) {

        // check col up
        for (int row = 0; row < r; row++) {
            if (board[row][c] == true) {
                return false;
            }
        }

        // check left diagonal
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        // check right diagonal
        i = r;
        j = c;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}