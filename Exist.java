// Problem 79. Word Search
// Time Complexity : O(M*N*4^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Exist {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int r, int c, String word, int idx) {
        // base case
        if (idx == word.length()) return true;
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(idx)) return false;
        // logic
        char temp = board[r][c];
        board[r][c] = '#';  // Mark the cell as visited
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (backtrack(board, nr, nc, word, idx + 1)) return true;
        }
        board[r][c] = temp;  // Backtrack
        return false;
    }
}
