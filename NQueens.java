/*
This is the classical N-Queens solution using DFS and Backtracking. We construct an N x N boolean matrix, and we test for
an N-Queens configuration by successively adding queens onto this matrix. Whenever we add a queen, we mark that location 
in the matrix, and we check if the placement was valid or not. The conditions for validity are checked by ensuring that there
was not another queen placed in the same row, column and diagonal. If it is not valid, we just backtrack to the locations of
previous queen placements and test out configurations again, till we find a configuration that matches.

Did this code run on leetcode: Yes
*/
class Solution {
    List<List<String>> result;
    boolean[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        
        board = new boolean[n][n];
        
        helper(0, n);
        
        return result;
    }
    
    private void helper(int index, int n)
    {   //If we find a matching configuration, we convert the boolean configuration to a String configuration and store it
        if(index == n)
        {   
            List<String> queens = new ArrayList<>();
                
            for(int i = 0; i < n; i++)
            {   
                StringBuilder str = new StringBuilder();
                
                for(int j = 0; j < n; j++)
                {
                    if(board[i][j])
                        str.append("Q");
                    
                    else
                        str.append(".");
                }
                queens.add(str.toString());
            }
            result.add(new ArrayList<>(queens));
            
            return;
        }
        
        for(int j = 0; j < n; j++)
        {
            //When a row placement is valid, we move on to the next row for the next placement, as we would not need to place a queen on that same row
            if(isValid(index, j, n))
            {   
                board[index][j] = true;
                helper(index + 1, n);
            }
            
            board[index][j] = false;
        }
    }
    
    private boolean isValid(int i, int j, int n)
    {   
        //We check vertically on the same column above the current location of the placement, since the lower rows would not have any queens to be checked
        for(int k = 0; k < i; k++)
            if(board[k][j])
                return false;
        
        int r = i;
        int c = j;
        
         //We check diagonally on the left diagonal above the current location of the placement, since the lower diagonal          
         //would not have any queens to be checked
        while(r >= 0 && c >= 0)
        {
            if(board[r][c])
                return false;
            
            r--;
            c--;
        }
        
        r = i;
        c = j;
        
        //We check diagonally on the right diagonal above the current location of the placement, since the lower diagonal          
        //would not have any queens to be checked
        while(r >= 0 && c < n)
        {
            if(board[r][c])
                return false;
            
            r--;
            c++;
        }
        
        return true;
    }
}