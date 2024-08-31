//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class WordSearch {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        this.m = board.length;
        this.n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;

    }

    public boolean backtrack(char[][] board, String word, int r, int c, int idx){
        if(idx == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n) return false;
        if(board[r][c] == word.charAt(idx)){
            board[r][c] = '#';
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, nr, nc, idx+1)){
                    return true;
                }
            }
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}
