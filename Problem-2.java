class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(helper(board,word,0,i,j,dirs)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int index,int r, int c, int[][] dirs) {
        //base
        if(index == word.length()) {
            return true;
        }
        
        if(r<0 || c<0 || r==board.length || c == board[0].length) {
            return false;
        }
        
        //logic
        if(board[r][c] == word.charAt(index)) {
            //action
            char temp = board[r][c];
            board[r][c] = '#';
            //recursion
            for(int[] dir: dirs) {
                int row = r + dir[0];
                int col = c + dir[1];
                if(helper(board,word,index+1,row,col, dirs)){
                    return true;
                }
            }
            //bactrack
            board[r][c] = temp;
        }
        
        return false;
    }
}