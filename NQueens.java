// Time Complexity:O(n!)
// Space Complexity: 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * The idea is to place one queen in one row only. We iterate over each column of the row and we check if 
 * there is a queen in its top column, top left diagonal and top right diagonal. If it is safe for the queen, 
 * we make that spot true and then add it to the SB. Backtrack option is to make the spot false
 */

public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        
        if(n == 0)
            return result;
        
        boolean[][] board = new boolean[n][n];
        helper(board,0,n);
        return result;
    }
    
    private void helper(boolean[][] board, int row, int n)
    {
        //base
        if(row == n)
        {
            List<String> li = new ArrayList<>();
            
            for(int i = 0;i<row;i++)
            {
                StringBuilder sb = new StringBuilder();
                {
                    for(int j = 0; j < n;j++)
                    {
                        if(board[i][j])
                        {
                            sb.append('Q');
                        }
                        else
                        {
                            sb.append('.');
                        }
                    }
                    li.add(sb.toString());
                }
            }
                result.add(li);
                return;
        }
        
        //logic
        for(int j = 0; j < n;j++)
        {
            if(isSafe(board,row,j,n))
            {
                //action
                board[row][j] = true;
                
                //recurse
                helper(board,row + 1, n);
                
                //backtrack
                board[row][j] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col,int n)
    {
        //up column
        for(int i = 0; i < row;i++)
        {
            if(board[i][col] == true)
                return false;
        }
        
        //top left
        int i = row;
        int j = col;
        while(i >= 0 && j>= 0)
        {
            if(board[i][j] == true)
                return false;
            i--;
            j--;
        }
        
        //top right
         i = row;
         j = col;
        while(i >=0 && j < n)
        {
            if(board[i][j] == true)
                return false;
            i--;
            j++;
        }
        return true;
    }
}
