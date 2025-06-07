//Time Complexity :O(m*n*3l)
//Space complexity:O(l)
class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#' || board[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) return true;
        char temp = board[i][j];
        board[i][j] = '#';
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (dfs(board, word, r, c, idx + 1)) return true;
        }
        board[i][j] = temp;
        return false;
    }
}
