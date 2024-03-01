public class WordSearch {
    //TC: O(3^L)
    //SC: O(m*n)
    int dirs[][];
    int m, n;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int r, int c, int idx){
        //base
        if(idx == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c]=='#') return false;
        //logic
        if(word.charAt(idx) == board[r][c]){
            if(idx == word.length()) return true;
            //action
            board[r][c] = '#';
            //recurse
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(dfs(board, word, nr, nc, idx+1)) return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}
