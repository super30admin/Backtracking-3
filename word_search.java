class Solution {

    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if(m == 0 || board == null || word.length()  == 0) return false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word,i,j)) return true;
            }

        }
        return false;

    }

    private boolean backtrack(char[][] board,String word,int i, int j){
        // base case
        if(i < 0 || i >= m  || j < 0 || j >= n || board[i][j] == '$') return false;
        // logic
        int [][] dirs = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        if(board[i][j] == word.charAt(0)){
            if(word.length() == 1) return true;
            char temp = board[i][j];
            board[i][j] = '$'; 
            for(int [] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board, word.substring(1), r, c)) return true;

            }

            // backtrack 
            board[i][j] = temp; 

        } 

        return false;

    }

}

