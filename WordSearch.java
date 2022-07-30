//Time Complexity: O(m*n * 3^l) traversing the board and at each cell looking at 3 directions for the length of the word
//Space Complexity: O(l) , recursive stack space

class Solution {
    int m, n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // r&c for board, index for word
    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // base
        if (index == word.length())
            return true;
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;

        // logic
        if (word.charAt(index) == board[r][c]) {
            // action
            char ch = board[r][c];
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // recurse
                if (backtrack(board, word, nr, nc, index + 1)) {
                    return true;
                }
            }

            // bactrack
            board[r][c] = ch;
        }
        return false;
    }
}