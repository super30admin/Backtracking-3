public class WordSearch {
    int dirs[][];
    int m, n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        this.m = board.length;
        this.n = board[0].length;
        flag = false;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(!flag){
                    dfs(board, r, c, word, 0);
                }else{
                    break;
                }
            }
        }
        return flag;
    }

    //backtracking based dfs approach 
    public void dfs(char[][] board, int r, int c, String word, int i){
        //base 
        if(i == word.length()){
            flag = true;
            return;
        }
        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] == '#') return;

        //logic
        if(board[r][c] == word.charAt(i)){
            board[r][c] = '#';
            for(int d[] : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                dfs(board, nr, nc, word, i+1);
            }
            board[r][c] = word.charAt(i);
        }


    }
}
