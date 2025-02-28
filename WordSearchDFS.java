// Time Complexity : O((m+n)* 3^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class WordSearchDFS {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int [][]{{0,1}, {1,0},{-1,0},{0,-1}};
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, int idx, String word) {
        // base
        if (idx == word.length()) return true;
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '#') return false;

        // logic
        if (board[r][c] == word.charAt(idx)) {
            // action
            board[r][c] = '#';
            // recurse
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, nr, nc, idx+1, word)) return true;
            }
            // backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}
