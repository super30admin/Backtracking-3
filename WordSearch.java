class Solution {
    int[][] dirs;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //right, down, left, top
        flag = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // System.out.println(i + " "+ j +"##");
                // if(board[i][j] == word.charAt(0))
                    helper(board,i,j,0,word);
            }
        }
        
        return flag;
    }

    private void helper(char[][] board, int m, int n, int idx, String word){
        // base
        if(idx == word.length()){
            flag = true;
            return;
        }
        if(m<0 || n<0 || m>=board.length || n>=board[0].length || board[m][n]=='#') return;

        //logic
        if(board[m][n] == word.charAt(idx)){

            board[m][n] = '#'; //action
            for(int[] dir:dirs){ //recurse
                
                int nr = m + dir[0];
                int nc = n + dir[1];
                helper(board,nr,nc,idx+1,word);
                
            }
            // backtrack
            board[m][n] = word.charAt(idx);
        }
        
        
    }
}