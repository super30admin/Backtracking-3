class Solution {
    public boolean exist(char[][] board, String word) {
        
        //edge case
        
        if(board==null || board.length ==0) return false;
        for(int i = 0 ; i <board.length;i++)
        {
            for(int j = 0 ; j<board[0].length;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    // backtracking function
                    if(backtracking(board,i,j,0,word))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean backtracking(char[][] board,int i , int j,int index, String word)
    {
        //base case
        if(index == word.length()-1)
        {
            return true;
        }
        
        //recursive case
        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] dirs:directions)
        {
            int x = i+dirs[0];
            int y = j+dirs[1];
            if(x>=0 && x<board.length && y >=0 && y <board[0].length &&  (index+1)<word.length() && word.charAt(index+1)==board[x][y])
            {
              
                if(backtracking(board,x,y,index+1,word))
                {
                    return true;
                }
                 
            }
        }
        board[i][j] = temp;
        return false;
    }
}