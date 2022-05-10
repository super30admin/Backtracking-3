class wordSearch {
    int m,n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtracking(board, word, i, j, 0) == true) return true;
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, String word, int i, int j, int index){
        
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#'){
            return false;
        }
        
        if(word.charAt(index) == board[i][j]){
            char ch = board[i][j];
            board[i][j] = '#';
            for(int[] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(backtracking(board, word, nr, nc, index +1) == true) return true;
            }
            board[i][j] = ch;
        }
        return false;
    }
}

//time complexity O(2^n)
//space complexity O(length of the word) as we put in recursive stack only if we find the char by char