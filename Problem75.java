// Time Complexity : O(m * n * 4^L) 
// Space Complexity : O(L)

class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, n ,m, word, 0, dirs)) return true;
            }
        }

        return false; 
    }

    private boolean dfs(char[][] board, int i, int j, int n, int m, String word, int idx, int[][] dirs) {
        //base
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        if (board[i][j] != word.charAt(idx)) return false;

        //logic
        board[i][j] = '#';

        for (int[] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(dfs(board, r, c, n, m, word, idx+1, dirs)) return true;
        }

        board[i][j] = word.charAt(idx);

        return false;
    }
}