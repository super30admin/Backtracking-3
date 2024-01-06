class Solution {
    
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0) return true;
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j =  0; j < board[0].length; j++)
            {
                if(helper(board, word, i, j, 0) == true) return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int index)
    {
        if(index == word.length()) return true;
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == '@') 
            return false;

        if(word.charAt(index) == board[row][col])
        {
            char ch = board[row][col];
           for(int[] dir : dirs)
           {
               int new_row = row + dir[0];
               int new_col = col + dir[1];
               
               board[row][col] = '@';
               
               if(helper(board, word, new_row, new_col, index + 1) == true) 
                   return true;
           }
           board[row][col] = ch;
        }
        
        return false;
    }
}