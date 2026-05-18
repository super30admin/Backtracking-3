class Solution {
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        // base
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;

        //logic 
        if(board[i][j]!=word.charAt(idx)) return false;
        board[i][j] = '#';
        for(int[]dir:dirs){
            int r= i+dir[0];
            int c = j+dir[1];
            if(dfs(board, r, c, word, idx+1)) return true;
        }
        board[i][j] = word.charAt(idx);
        return false ;
    }
}