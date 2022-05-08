//tc: exponential
//sc: dimensions of board: m * n
class Solution {
    int[][] dirs;
    int m, n;  
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtracking(board, word, i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(char[][] board, String word, int r, int c, int index) {
        //base
        if(index == word.length()) {
            return true;
        }
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') {
            return false;
        }
        //logic
        if(board[r][c] == word.charAt(index)) {
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            //recurse
            for(int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(backtracking(board, word, nr, nc, index + 1) == true) {
                    return true;
                }
                }
                //backtracking
                board[r][c] = ch;  
        }
        return false;
    }
}