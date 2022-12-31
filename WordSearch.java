
public class WordSearch {

        private int[][] dirs;
        public boolean exist(char[][] board, String word) {
            if (board == null) return false;
            dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
            int m = board.length;
            int n = board[0].length;
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (word.charAt(0) == board[i][j] && board[i][j] != '#' &&
                    helper(board, word, 0,i,j,m,n)) return true;
                }
            }
            return false;
        }
    
        private boolean helper(char[][] board, String word, int idx, int r, int c, int m, int n){
            //base
            if (idx == word.length()) return true;
            if (r<0 || c<0 || r== m || c==n || (board[r][c] == '#')) return false;
            
            //logic
            if (word.charAt(idx) == board[r][c]){
                //action
                board[r][c]= '#';
                //recurse        
                for (int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (helper(board, word, idx+1, nr, nc, m, n)) return true;
                }
                //backtrack
                board[r][c]= word.charAt(idx);
            }
            return false;
        }
    
}
