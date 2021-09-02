
// Time Complexity : O(2*N)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*Approach
1) in this question, we generally want to place queeens such that they dont attack each other.
2) we use backtracking in the approacn, declare a boolean matrix and backtrack. 
3) we backtrack on each column of each row in action of backtrack method
4) we try to place the queen and then check isSafe() method
5) in isSafe method, we need to check upper left diagonal, upper rows and upper right diagonal
6) we dont need to check downwards, as we would be doing that in subsequent rows. Thus we can handle this situation of going downward with each backtrack call. 
7) Thus isSafe will cover all upward positions till the point where we have reached.
*/


import java.util.*;
class NQueens {
    
    List<List<String>> res;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
       
        res = new ArrayList<>();
        if(n==0)
        {
            return res;
        }
        
        grid= new boolean[n][n];
        
        // calling the helper function
        
        backtrack(n,0); // we require to send the n in the helper function
    
        return res;
        
    }
    public void backtrack(int n,int row)
    {
        // base 
        if(row==n)
        {
            List<String> li = new ArrayList();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j])
                    {
                        sb.append("Q");
                        
                    }
                    else
                    {
                        sb.append(".");
                    }
                    
                }
                li.add(sb.toString());
            }
            res.add(li);
            
        }
        
        
        // action
        // iterating along every column in that particular row
        for(int i=0;i<n;i++)
        {
            if(isSafe(n,row,i))
            {
                //action
                grid[row][i]=true;
                
                // recurse 
                backtrack(n,row+1);
                
                // backtrack
                grid[row][i]=false;
                
            }
            
        }
        
        
        
    }
    
    private boolean isSafe(int n, int row, int col)
    {
        // here we need to check for upper rows, upper columns, upper left diagonal and upper right diagonal
        
        // check upper rows
        for(int i=0;i<row;i++)
        {
            if(grid[i][col])
            {
                return false;
            }
        }
        
        // check for upper diagonal
        int i=row, j=col;
        while(i>=0 && j>=0)
        {
            if(grid[i][j])
            {
                return false;
            }
            i--;
            j--;
        }
        
        // check for upper right diagonal
        i=row; 
        j=col;
        
        while(i>=0 && j<n)
        {
            if(grid[i][j])
            {
                return false;
            }
            i--;
            j++;
        }
        
        
        
       return true; 
    }
    
    
    
}