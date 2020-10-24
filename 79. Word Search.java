class Solution {// class solution time of N * 4^ word length  and space of O(word length)
    int nrows;
    int ncols;
    char[][] board_info;
    public boolean exist(char[][] board, String word) {
        //base case
        if(board == null)
            return false;
        board_info = board ;
        nrows = board.length;
        ncols = board[0].length;
        if(nrows == 0|| ncols == 0 || word.length() == 0)
            return false;
        if(nrows == 1 && ncols == 1 && word.length() == 1 &&word.charAt(0) == board_info[0][0])                   return true;
        for(int i= 0 ;i< nrows ; i++)
        {
            for(int j = 0 ; j< ncols ;  j++)
            {
                if(word.charAt(0) == board_info[i][j] && helper(word,i,j,0)) return true;
            }
        }
        return false; 
    }
    private boolean helper(String word, int row , int col , int strindex){
        //Base case
        if(strindex >= word.length())
            return true;
        
        if( board_info[row][col] != word.charAt(strindex))
            return false;
        
        char prev = board_info[row][col];
        board_info[row][col] = '#' ;
            //Top
            if(row>0 && helper(word,row-1 ,col ,strindex + 1)) return true;
            //Bottom
            if(row + 1 < board_info.length && helper(word,row+1 ,col ,strindex + 1) ) return true;
            //Left
            if(col > 0 && helper(word,row ,col-1 ,strindex + 1)) return true;
            //Right
            if(col + 1 < board_info[0].length && helper(word,row ,col+1 ,strindex + 1)) return true;
        
        board_info[row][col] = prev;
        return false; 
    }
}