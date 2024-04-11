//TC: O(3^L *n*m) L- length of the word, n*m - board 
//SC: O(L) L- length of the word
class Solution {
    private int[][] dirs;
    int n; int m ;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][] {{0,-1}, {-1,0}, {1,0},{0,1}};
        m = board.length;
        n = board[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j <n;j++ ){
                if(!flag){
                    helper(board, word, i ,j,0);
                }
            }
        }
        return flag;
    }
    private void helper(char[][] board, String word, int i, int j, int idx){
        //base
        if(idx == word.length()){
            flag = true;
            return;
        }
        if(i <0 || j< 0 || i==m || j==n || board[i][j] == '#') return;

        //logic
        
            if(word.charAt(idx) == board[i][j]){
                //action
                board[i][j] = '#';
                //recurse
                for(int[] dir : dirs){
                    int nr = dir[0] + i;
                    int nc = dir[1] + j;
                    if(!flag){
                        helper(board, word, nr,nc, idx+1);
                    }
                    if(flag) break;
                }
                //backtrack
                board[i][j] = word.charAt(idx);
            }
    }
}