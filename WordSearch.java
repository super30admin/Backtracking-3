/**
 * Time Complexity: O(m * n) * 3 * l where l is length of the word
 * Space complexity: O(l) where l is the length of the word.
 */

public class WordSearch {

    int m, n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if (board[i][j] == word.charAt(0)) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
                // }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        // base
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row == m || col < 0 || col == n || board[row][col] == '#') {
            return false;
        }

        // logic
        if (board[row][col] == word.charAt(index)) {
            // action
            char temp = board[row][col];
            board[row][col] = '#';
            // recurse
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (backtrack(board, newRow, newCol, word, index + 1)) {
                    return true;
                }
            }
            // backtrack
            board[row][row] = temp;
        }
        return false;
    }

}
