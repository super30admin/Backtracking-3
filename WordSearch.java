// Time Complexity : m*n*3^l where m = length of row, n = length of coloumn, l = length of the String
// Space Complexity : m*n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class WordSearch {
    int dirs[][];
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        this.m = board.length;
        this.n = board[0].length;
        // Iterate over board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int r, int c, String word, int index) {
        // base
        if (index == word.length())
            return true;
        if (r < 0 || c < 0 || r == m || c == n)
            return false;
        // logic
        if (board[r][c] == word.charAt(index)) {
            // Action
            board[r][c] = '#';
            // iterate over dirs array
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // Recurse
                if (helper(board, nr, nc, word, index + 1))
                    return true;
            }

            // Backtrack
            board[r][c] = word.charAt(index);
        }
        return false;
    }
}