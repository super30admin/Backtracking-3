public class WordSearch {
    // Time Complexity: O(N*3^L) where L is length of word
    // SC O(L)

    class Solution {
        boolean found = false;
        int[][] dirs;

        public boolean exist(char[][] board, String word) {
            dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (helper(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean helper(char[][] board, int row, int col, int index, String word) {
            if (index == word.length())
                return true;
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#')
                return false;
            if (board[row][col] == word.charAt(index)) {
                char ch = board[row][col];
                board[row][col] = '#';
                int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (helper(board, r, c, index + 1, word)) {
                        return true;
                    }
                }
                board[row][col] = ch;
            }

            return false;
        }
    }
}
