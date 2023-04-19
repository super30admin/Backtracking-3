public class WordSearch {
    //Leetcode -
    //Time Complexity - M*N(3^L) where M - rows, N - cols, L - length of word, at each node, we have 3 nodes to explore
    //Space Complexity - o(l)
    private int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, i, j, word, 0, m, n)) return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, int i, int j, String word, int idx, int m, int n){
        //base
        if(idx == word.length()) return true;
        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#') return false;

        //logic
        //action
        if(board[i][j] == word.charAt(idx)) {
            board[i][j] = '#';
            //recurse
            for(int [] dir : dirs) {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if(backtrack(board, nr, nc, word, idx+1, m , n)) return true;
            }
            //backtrack
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}
