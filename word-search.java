// Time Complexity : O(m × n × 3^L)
// Space Complexity : O(m × n + L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m;
    int n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // base cases
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;

        // if full word matched
        if (index == word.length() - 1) return true;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (dfs(board, word, r, c, index + 1)) return true;
        }

        // backtrack
        visited[i][j] = false;

        return false;
    }
}
