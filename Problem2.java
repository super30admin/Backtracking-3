// TC: O(mn * 4^k)
// SC: O(1)
public class Problem2 {
    boolean result;
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.result = false;
        this.dirs = new int[][]{{-1,0},{1,0}, {0,1},{0,-1}};
        this.m = board.length;
        this.n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!result){
                    helper(board, word, i, j, 0);
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public void helper(char[][] board, String word, int i, int j, int idx){
        //base case
        if(idx == word.length()){
            result = true;
            return;
        }

        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#') return;

        //logic
        if(word.charAt(idx)==board[i][j]){
            board[i][j]='#';
            for(int[] dir: dirs){
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                helper(board, word, nr, nc, idx+1);
            }
            board[i][j] = word.charAt(idx);
        }
    }
}
