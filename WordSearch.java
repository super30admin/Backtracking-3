class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row){
            for (int col = 0; col < this.COLS; ++col){
                if (this.backtrack(row, col, word, 0))
                    return true;  
            }
        }
          return false;
    }
    
    private boolean backtrack(int r, int c, String word, int index){
        if(index>= word.length()) return true;
        
        if(r< 0|| r== this.ROWS || c< 0 || c== this.COLS || this.board[r][c] != word.charAt(index))
            return false;
        
        boolean ret = false;
        this.board[r][c] = '#';
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int dir=0; dir< 4 ;dir++){
            ret= backtrack(r+rowOffsets[dir], c+ colOffsets[dir], word, index+1);
            if(ret) return true;
        }
        
        this.board[r][c] = word.charAt(index);
        return ret;
    }
}

//Time Complexity: O(N*3^L) where N is the number of cells in the board and L is the length of the word to be matched.
//Space complexity- O(L)