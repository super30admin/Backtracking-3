//time O(3^n)
//space O()

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int [][] dirs = new int[][]{{0,1},{0,-1}, {-1,0},{1,0}};
        if(board == null || board.length ==0) return false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                if(backtrack(board, i,j, m,n, 0, word, dirs)) return true;
            }
        }
        return false;
    }
    boolean backtrack(char[][] board, int r, int c, int m , int n, int i, String word, int[][] dirs){
        
          if( i == word.length()){
            return true;
        }
        
        if(r<0 || c<0|| r==m || c==n ||board[r][c] == '#' ){
            return false;
        }
        
        if(board[r][c] == word.charAt(i)){
            board[r][c]=  '#';
            for(int[] dir: dirs){
                int nr = r +dir[0];
                int nc = c + dir[1];
                if(backtrack(board, nr, nc, m, n, i+1, word, dirs)) return true;
            }
            board[r][c] = word.charAt(i);
        }
        return false;
    }
}