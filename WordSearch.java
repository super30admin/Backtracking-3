public class WordSearch {
    // TC:O(m*n)*(3^L)
    // SC:O(1)
    int m, n;
    boolean flag;
    String word;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{0,1}, {0,-1}, {1,0},{-1,0}};
        this.m = board.length;
        this.n = board[0].length;
        this.flag = false;
        this.word = word;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!flag){
                    dfs(board, i, j, 0);
                }
            }
        }
        return flag;
    }
    private void dfs(char[][] board, int i, int j, int idx){
        //base case
        if(idx == word.length()){
            flag = true;
            return;
        }
        if(i < 0 || j < 0 || i==m || j==n || board[i][j] == '#'){
            return;
        }
        if(board[i][j] != word.charAt(idx)){
            return;
        }
        //logic
        board[i][j] = '#';
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(board, r, c, idx+1);
        }
        board[i][j] = word.charAt(idx);
    }
}
