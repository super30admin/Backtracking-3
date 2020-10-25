class Solution {
    
    int nrows;
    int ncols;
    char[][] board_info;
    public boolean exist(char[][] board, String word) {
        board_info = board;
        nrows = board.length;
        ncols = board[0].length;
        //Base case
        if(board==null || nrows==0 || ncols==0 || word.length()==0)
        {
            return false;
        }
        
        for(int i=0; i< nrows; i++)
        {
            for(int j=0; j< ncols; j++)
            {
                if(board[i][j] == word.charAt(0) && helper(word,i, j,0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(String word, int row, int col, int strindex){
        
        if(strindex >= word.length())
            return true;
        
        if(row <0 || row >= nrows || col<0|| col>=ncols || board_info[row][col] != word.charAt(strindex)) return false;
        
        char prev = board_info[row][col];
        board_info[row][col] = '#';
        
        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        
        for(int[] dir: dirs)
        {
            int new_row = row+dir[0];
            int new_col = col+dir[1];
            
            if(helper(word, new_row, new_col, strindex+1))
                return true;
        }
        board_info[row][col] = prev;
        return false;
    }
}

// TC- O(3^K), where K is the length of given word, 3 here shows the choices that 
// algorithm explores at each position
//SC- O(K)- because that's the max storage the algorithm would use
