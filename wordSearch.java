// Time Complexity : m*n*3L , L = length of string
// Space Complexity: O(L), recusrive stack space will be L levels of tree.
// In worst case each cell will have 3 options to choose from for moving further.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do DFS from where start character is found. Mark them visited, and use backtracking
// to mark them unvisited.


class Solution {
    int m;
    int n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) { //m*n
                    if(dfs(0, i, j, board, word)) return true;
                }
            }
        }

        return false;
    }
    //3^L
    private boolean dfs(int i, int r, int c, char[][] board, String word) {
        //base,
        // we finish complete string
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;
        

        if (board[r][c] == word.charAt(i)) {
            //action
            board[r][c] = '#';
            //recurse
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (dfs(i + 1, nr, nc, board, word)) return true;
            }
            //backtrack
            board[r][c] = word.charAt(i);
        }

        return false;
    }
}