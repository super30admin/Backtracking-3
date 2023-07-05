class Solution {
    boolean flag;
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        flag = false;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                helper(board, word, 0, i, j, dirs);
            }
        }
        return flag;
    }

    public void helper(char[][] board, String word, int idx, int i, int j, int[][] dirs) {
        if (idx == word.length()) {
            flag = true;
            return; 
            // Add a return statement here to terminate the recursion
        }
        if (i >= n || j >= m || i < 0 || j < 0 || board[i][j] == '#') {
            return;
        }



        if (word.charAt(idx) == board[i][j]) {
            board[i][j] = '#';

            for (int[] d : dirs) {
                int nr = d[0] + i;
                int nc = d[1] + j;

                helper(board, word, idx + 1, nr, nc, dirs);
            }
            board[i][j] = word.charAt(idx);
        }
    }
}