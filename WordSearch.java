// Time complexity: O(n^2)
// Space complexity: O(n^2)

class Solution {
    boolean ans;
    int [][] dirs = new int [][] {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    helper(board, visited, 1, i, j, word);
                    visited[i][j] = false;
                }

            }
        }
        return ans;

    }

    private void helper(char [][] b, boolean [][] v, int idx, int i, int j, String word) {
        if(idx == word.length() || ans) {
            ans = true;
            return;
        }
        for (int [] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(r >= 0 && r < b.length && c >=0 && c < b[0].length && b[r][c] == word.charAt(idx) && !v[r][c]) {
                v[r][c] = true;
                helper(b, v, idx + 1, r, c, word);
                v[r][c] = false;
            }
        }

    }
}