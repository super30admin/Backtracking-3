// Time Complexity : O(n* m* 4 ^ l) [m: rows in board;  n: col in board; l: length of the word]
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] dirs;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        return helperDfs(board, word);
    }

    private boolean helperDfs(char[][] board, String word) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] == '#') {
            return false;
        }


        if (board[r][c] == word.charAt(idx)) {
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (dfs(nr, nc, board, word, idx + 1)) {
                    return true;
                }
            }
            board[r][c] = word.charAt(idx);
        }

        return false;
    }
}