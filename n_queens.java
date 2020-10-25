class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        //Initialize
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n;j++)
                board[i][j]='.';
        }
        
        List<List<String>> output = new ArrayList<>();
        helper(board,0,output);
        return output;
    }
    
    private void helper(char[][] board, int colIndex, List<List<String>> out)
    {
        // We reached the end of board, at this point we have
        // queen's position in that row.Making the format like-"...Q.."
        if(colIndex == board.length)
        {
            out.add(ConstructOutput(board));
            return;
        }
        // Backtracking approach, here we are going row-wise
        for(int i=0; i< board.length;i++)
        {
            // checking if queen can be placed at current position
            if(Validate(board,i,colIndex))
            {
                // Make a choice
                board[i][colIndex] ='Q';
                // Explore based on made choice for the next column
                helper(board,colIndex+1,out);
                // Undo the choice for next iteration
                board[i][colIndex]='.';
            }
        }
    }
    private List<String> ConstructOutput(char[][] board)
    {
        List<String> result = new LinkedList<>();
        for(int i=0; i<board.length;i++)
        {
            String s = new String(board[i]);
            result.add(s);
            
        }
        return result;
    }
    private boolean Validate(char[][] board, int row, int col)
    {
        for(int i=0; i<board.length;i++)
        {
            for(int j=0; j<col; j++)
            {
                if(board[i][j]=='Q' &&(i==row || row+col == i+j || row+j == col+i))
                    return false;
            }
        }
        return true;
    }
}

// TC- O(n!)- because at every queen's placement there is one less choice for the next queen
// SC- O(n) since in all n queens are placed. In the worst case, 
