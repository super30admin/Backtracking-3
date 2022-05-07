// Time Complexity : O(n!), n chices in first rown, n-1 in second row, n-2 in third row and so on
// Space Complexity : O(n^2), we need to mantain grid of n^2 size.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, debugged and found issue


// Your code here along with comments explaining your approach

List<IList<string>> result;
    bool[,] grid;
    public IList<IList<string>> SolveNQueens(int n) {
        
        result = new List<IList<string>>();
        if(n == 0)
            return result;
        
        grid = new bool[n,n];
        backtracking(0);
        
        return result;
    }
    
    private void backtracking(int row)
    {
        //base
        if(row == grid.GetLength(0))
        {
            List<string> newLst = new List<string>();
            for(int i = 0; i < grid.GetLength(0); i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < grid.GetLength(1); j++)
                {
                    if(grid[i,j])
                        sb.Append("Q");
                    else
                        sb.Append(".");
                }
                newLst.Add(sb.ToString());
            }
            result.Add(newLst);
            return;
        }
        
        //logic
        for(int i = 0; i < grid.GetLength(1); i++)
        {
            if(isSafe(row, i))
            {
                //action
                grid[row,i] = true;
                
                //recurse
                backtracking(row+1);
                
                //backtrack
                grid[row,i] = false;
            }
        }
    }
    
    private bool isSafe(int r, int c)
    {
        int i = 0;
         //check th eabove column to see if any other queen is present.
        for(i = 0; i < r; i++)
        {
            if(grid[i,c] == true)
            return false;
        }
        
        i = r;
        int j = c;
        //check th upper right
        while(i >= 0 && j < grid.GetLength(1))
        {
            if(grid[i, j] == true)
                return false;
            i--;
            j++;
        }

        i = r;
        j = c;
        //check the upper left
        while(i >= 0 && j >= 0)
        {
            if(grid[i,j] == true)
                return false;
            i--;
            j--;
        }
        return true;
    }