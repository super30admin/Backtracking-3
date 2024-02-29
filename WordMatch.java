// TC - O(M*N 3^L) => O(3^L) => Each cell has 3 to choose
// SC - O(Size of Word) => Stack space

public class WordMatch {
    class Solution {
        private final int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, word, i, j, 0)) {
                            return true;
                        }
                        ;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int row, int col, int index) {
            if (index == word.length()) {
                return true;
            }

            if (row < 0 || row == board.length ||
                    col < 0 || col == board[0].length ||
                    board[row][col] == '#') {
                return false;
            }

            if (board[row][col] == word.charAt(index)) {
                board[row][col] = '#';

                for (int[] dir : dirs) {
                    int currRow = row + dir[0];
                    int currCol = col + dir[1];
                    if (dfs(board, word, currRow, currCol, index + 1)) {
                        return true;
                    }
                }

                board[row][col] = word.charAt(index);
            }

            return false;
        }
    }
}
