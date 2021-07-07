class WordSearch{
    int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        // time - N * 3 ^ L: L-word.length
        // space -  L: L-word.length

        if(board == null || board.length == 0 || board[0].length ==0) return false;
        dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        // base
        if(index == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c] != word.charAt(index)) return false;

        // logic
        //action
        char temp = board[r][c];
        board[r][c] = '#';

        //recurse
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(backtrack(board, word, nr, nc, index+1)) return true;
        }

        //backtrack
        board[r][c] = temp;
        return false;
    }
}