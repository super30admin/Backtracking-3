class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               if(helper(board, word, 0,i,j)){
                return true;
               }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int idx, int r, int c){

        //base
        if(idx==word.length()){
            return true;
        }

        if(r<0 || c<0 || r>=board.length || c>=board[0].length)
        {
            return false;
        }

        //logic
        if(board[r][c]==word.charAt(idx)){
            board[r][c] = '#';
            for(int[] dir : dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(helper(board, word, idx+1,nr,nc)){
                    return true;
                }
               
            }
             //backtrack
                board[r][c] = word.charAt(idx);

        }

        return false;
      
    }
}