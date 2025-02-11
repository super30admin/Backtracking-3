class WordSearch {
    int[][] dirs = {{0,-1}, {-1,0}, {0, 1}, {1, 0}};
    int m, n;
    boolean isValid;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0){
            return false;
        }

        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    board[i][j] = '#';
                    recurse(board, i, j, word, 1);
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return isValid;
    }

    private void recurse(char[][] board, int row, int col, String word, int index){
        if(word.length() == index){
            isValid = true;
            return;
        }

        for(int[] dir: dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if(nr>=0 && nc>=0 && nr<m && nc<n){
                if(word.charAt(index) == board[nr][nc]){
                    board[nr][nc] = '#';
                    recurse(board, nr, nc, word, index+1);
                    board[nr][nc] = word.charAt(index);
                }
            }
        }
    }
}
