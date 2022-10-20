class Solution {
    // T.C : O(m * n * 3 pow L) // L is length, m * n for traversal
    // S.C : O(N) // N is length of word
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.length() == 0)
            return true;
        
        m = board.length;
        n = board[0].length;
        
        dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isBacktrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isBacktrack(char[][] board, int r, int c, String word, int index) {
        // base
        if (index == word.length())
            return true;
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#' )
            return false;
        // logic
        if (board[r][c] == word.charAt(index)) {
            char ch = board[r][c];
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (isBacktrack(board, nr, nc, word, index + 1)) {
                    return true;
                }
            }
            
            // backtrack
            board[r][c] = ch;
        }
        return false;
    }
}