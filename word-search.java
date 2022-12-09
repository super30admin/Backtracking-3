//tc is O(3^L)
//sc is O(L) where L is length of string
class Solution {
    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0)
            return false;

        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        m = board.length;
        n = board[0].length;

        // traverse the matrix

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean backtrack(char[][] board, String word, int index, int r, int c) {
        // base
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;

        // logic
        if (board[r][c] == word.charAt(index)) {
            char ch = board[r][c];

            board[r][c] = '#';

            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if (backtrack(board, word, index + 1, nr, nc)) {
                    return true;
                }
            }

            // backtrack
            board[r][c] = ch;

        }

        return false;
    }
}