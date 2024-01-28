class Solution {
    //TC: O(2^(mn))
    //SC: O(n)
    private int [][] dirs; int m , n;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0,1},{1,0}, {-1,0}, {0,-1}};
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board,i,j,word,0)) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board,int r,int c,String word, int idx){
        //base
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;
        
        //logic
        if(board[r][c] == word.charAt(idx)){
            if(idx == word.length() - 1) return true;
            //action
            board[r][c] = '#';
            //recurse
            for(int [] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(backtrack(board, nr, nc , word, idx + 1)) return true;
            }
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}