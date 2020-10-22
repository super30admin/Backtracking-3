/**
 * Time Complexity : O(N. 3^K)
 * Space Complexity: O(K) k is length of the string
 */


class Solution {
    
    int nrows;
    int ncols;
    char[][] board_info;
    public boolean exist(char[][] board, String word) {
        
        if(board ==null)
            return false;
        board_info = board;
        nrows = board.length;
        ncols = board[0].length;
        
        if(nrows == 0 || ncols == 0 || word.length() == 0)
            return false;
        
        for(int i=0;i<nrows;i++)
        {
            for(int j=0;j<ncols;j++)
            {
                if(word.charAt(0) == board[i][j] && helper(word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(String word, int row, int col, int strindex)
    {
        if(strindex >= word.length())
        {
            return true;
        }
        
        if(row<0 || row>= nrows || col<0 || col >=ncols || board_info[row][col] !=word.charAt(strindex))
            return false;
        
        char prev = board_info[row][col];
        board_info[row][col] ='#';
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir : dirs)
        {
            int new_row = row+dir[0];
            int new_col = col +dir[1];
            
            if(helper(word,new_row,new_col,strindex+1))
                return true;
        }
        board_info[row][col] = prev;
        return false;
    }
}