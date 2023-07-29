// Time Complexity: O(mxnx3^L) where L is the length of the word
// Space Complexity: O(L) recursive call stack


class Solution2 {
    private int[][] dirs;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( board[i][j] == word.charAt(0) ) {
                    if(backtrack(board, word, 0, i, j) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        //base case
        if( idx == word.length()) {
            return true;
        }
        if( i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') {
            return false;
        }

        //logic
        if( board[i][j] == word.charAt(idx) ) {
            board[i][j] = '#';
            for(int[] dir: dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtrack(board, word, idx+1, nr, nc)) {
                    return true;
                }
            }
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}