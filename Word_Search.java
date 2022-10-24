// TC : O(m*n*3^l)
// SC : O(l) l is length of word
// for loop based backtrack

class Solution {
    int[][] dirs;
    boolean isFound;
    public boolean exist(char[][] board, String word) {
        
        if((board == null || board.length == 0) && word == null) return false;
        
        int m = board.length;
        int n = board[0].length;
        
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && !isFound) {
                    char old = board[i][j];
                    board[i][j] = '#';
                    dfs(board, word, i, j, m, n, 1);
                    board[i][j] = old;
                }
            }
        }

        return isFound;
    }
    
    private boolean check(int m, int n, int row, int col) {
        if(row < m && row >=0 && col < n && col >= 0)
            return true;
        return false;

    }
    
    private void dfs(char[][] board, String word, int row, int col, int m, int n, int index) {
        
        if(index == word.length()) {
            isFound = true;
            return;
        }
        
        
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(check(m, n , nr , nc) && board[nr][nc] == word.charAt(index)) {
                char old = board[nr][nc];
                board[nr][nc] = '#';
                dfs(board, word, nr, nc, m, n, index+1);
                board[nr][nc] = old;
            }
        }

    }
}
