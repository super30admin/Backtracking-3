// Tc - 3^L
public class Solution {
    int[][] dirs;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(idx)) return false;
        board[r][c] = '#';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (backtrack(board, nr, nc, word, idx + 1)) {
                return true;
            }
        }
        board[r][c] = word.charAt(idx);
        return false;
    }
}
 
