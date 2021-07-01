/**
 * @author Vishal Puri
 * // Time Complexity : O(m*n)
 * // Space Complexity : O(m*n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Exist {
    int m, n;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, 1, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int r, int c) {
        //base
        if (index == word.length()) {
            return true;
        }

        //logic
        visited[r][c] = 1;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && visited[nr][nc] == 0 && board[nr][nc] == word.charAt(index)) {
                //System.out.println("test1"+word.charAt(index));
                if (backtrack(board, word, index + 1, nr, nc))
                    return true;
            }
        }
        visited[r][c] = 0;
        return false;
    }
}