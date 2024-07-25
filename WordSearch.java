// Time Complexity: O(3^l) l - length of string
// Space Complexity: O(l)  Size of recursive stack will also be L, since its the maximum depth possible

class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (backtrack(board, i, j, word, 0, dirs))
                    return true;

        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx, int[][] dirs) {
        // base
        if (idx == word.length())
            return true;
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1)
            return false;

        // logic
        if (board[r][c] == word.charAt(idx)) {
            board[r][c] = '#';

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, nr, nc, word, idx + 1, dirs))
                    return true;
            }
            board[r][c] = word.charAt(idx);

        }

        return false;
    }
}