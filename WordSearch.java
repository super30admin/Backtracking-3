// Time Complexity : O(mxn) m - board length, n is cols in board
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: dfs for 4 dirs then 3 and so aon and so forth

public class WordSearch {
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return false;

        if (word.charAt(0) == board[i][j]) {
            if (word.length() == 1)
                return true;
            visited[i][j] = true;
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                if (dfs(board, word.substring(1), r, c))
                    return true;
            }
            // backtrack
            visited[i][j] = false;
        }

        return false;
    }
}
