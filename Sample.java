//****N-QUEENS - BACKTRACKING FOR LOOP BASED RECURSION****
//Time complexity-n!;
//Space complexity: n^2
//For time complexity: we are goind in each row like n options then n-1 options then n-2 options which is n!
class Solution {
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        backtrack(board, 0, n);
        return result;
    }
    
    private void backtrack(boolean[][] board, int r, int n)
    {
        //Base
        if(r==n)
        {
            //Convert boolean to string and add it to the result
            List<String> li=new ArrayList<>();
            
            for(int i=0;i<n;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++)
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
            result.add(li);
            return;
        }
        
        //logic
        //Iterating in the each col in the row 0,1,2,3;
        for(int j=0;j<n;j++)
        {
            //If the board[][] position is safe, place the queen
            if(issafe(board, r, j, n))
            {
                //action
                board[r][j]=true;
                //recurse
                //-Going to the next row
                backtrack(board, r+1, n);
                //backtrack
                board[r][j]=false;
                
            }
        }
        
    }
    
    private boolean issafe(boolean[][] board, int r, int c, int n)
    {
        //check for the upper column
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
            
        }
        
        //Check for upper left diagonal
        //r--, c--
        //But if we play with r and c, we will loose the pivot, Instead create a copy!
        int i=r;
        int j=c;
        while(i>=0 && j>=0)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j--;
        }
        
        //check for upper right diagonal 
        //For that resetting the i & j;
        i=r;
        j=c;
        while(i>=0 && j<n)
        {
            if(board[i][j])
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
