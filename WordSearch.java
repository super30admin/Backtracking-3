// Time Complexity O(n ^ L) where L is length of word
// Space Complexity O(1)
// Runs on LeetCode YES

class Solution {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int r, int c) {

        // base case
        if (index == word.length()) {
            return true;
        }
        if (r == board.length || c == board[0].length || r < 0 || c < 0) {
            return false;
        }

        if (board[r][c] == word.charAt(index)) {
            // action
            board[r][c] = '.';

            for (int[] dir : dirs) {
                int row = r + dir[0];
                int col = c + dir[1];

                // recurse
                if (backtrack(board, word, index + 1, row, col)) {
                    return true;
                }

            }

            // backtrack
            board[r][c] = word.charAt(index);
        }

        return false;
    }
}