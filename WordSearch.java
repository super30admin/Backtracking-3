class WordSearch {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    int m,n;
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0; i< m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = '#';
                    dfs(board, word, 1, i, j);
                    board[i][j] = temp;
                }
            }
        }
        return flag;
    }
    //TC is O(m^2*n^2)
    //SC is O(l) where l is word length
    public void dfs(char[][] board, String word, int idx, int i, int j){
        // base
        if(idx == word.length()){
            flag = true;
            return;
        }
        
        // logic
        for(int[] dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr >=0 && nc >= 0 && nr < m && nc < n && board[nr][nc] != '#' && idx < word.length() && board[nr][nc] == word.charAt(idx)){
                // action
                char temp = board[nr][nc];
                board[nr][nc] = '#';
                // recurse
                dfs(board, word, idx+1, nr, nc);
                //backtrack
                
                board[nr][nc] = temp;
            }
        }
    }
}