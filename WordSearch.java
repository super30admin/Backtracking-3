public class WordSearch {
    int[][] dirs;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {

        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0))
                    ;
                if (helper(board, i, j, word, 0))
                    return true;
            }
        }
        return false;

    }

    private boolean helper(char[][] board, int r, int c, String word, int idx) {
        // base
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r == m || c == n)
            return false;

        // logic
        if (board[r][c] == word.charAt(idx)) {
            // mark it as read
            board[r][c] = '#';

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (helper(board, nr, nc, word, idx + 1))
                    return true;
            }

            board[r][c] = word.charAt(idx);

        }
        return false;
    }

}