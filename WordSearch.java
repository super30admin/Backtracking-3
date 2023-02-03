class Solution {
    private boolean result;
    int [][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)return false;
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, word, i, j, m, n, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int r,int c, int m, int n, int wIdx){

        if(wIdx == word.length())return true;
        if(r < 0 || c<0 || r == m || c ==n || board[r][c] == '#')return false;
        if(board[r][c]!= word.charAt(wIdx))return false;
        board[r][c] = '#';

        for(int [] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(backtrack(board,word, nr,nc,m,n, wIdx+1))return true;
        }
        board[r][c] = word.charAt(wIdx);
        return false;

    }
}