// Time Complexity : O(3^word.length())
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class WordSearch {
    boolean[][] visited;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++ j) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        //  base
        if (index == word.length())
            return true;

        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;

        //  logic
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (dfs(board, x, y, index + 1, word))
                return true;
        }

        visited[i][j] = false;

        return false;
    }
}
