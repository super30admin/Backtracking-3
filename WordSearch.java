// Time Complexity : O(m*n*(3^L))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int[][] dirs;
    int m;
    int n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length())
            return true;
        // base cases
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '#')
            return false;
        // logic
        if (board[i][j] == word.charAt(idx)) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                if (backtrack(board, word, idx + 1, r, c))
                    return true;
            }
            // backtrack
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}