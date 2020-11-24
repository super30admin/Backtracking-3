//Time Complexity : O(n!)
//Space Complexity : O(n^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.List;
import java.util.ArrayList;
class N_Queens_51 {
    List<List<String>> result = new ArrayList<>();
    int[][] grid;
    int m;
    public List<List<String>> solveNQueens(int n) {
        
        grid = new int[n][n];
        m = n;
        helper(0);
        return result;
    }
    
    private void helper(int row)
    {
        // Base
        if(row == m)
        {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < m; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++)
                {
                    if(grid[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        // Logic
        for(int j = 0; j < m; j++)
            {
                if(isSafe(row, j))
                {
                    // Action
                    grid[row][j] = 1;
                    // recurse
                    helper(row + 1);
                    // Backtrack
                    grid[row][j] = 0;
                }    
            }
        }
    
    private boolean isSafe(int i, int j)
    {
        int r = i;
        int c = j;
        // Column up
        for(int k = 0; k <= i; k++)
        {
            if(grid[k][j] == 1)
                return false;
        }
        r=i;
        c=j;
        // Diagonal left up
        while(r >= 0 && c >= 0)
        {
            if(grid[r][c] == 1)
                return false;
            r--;
            c--;
        }
        r=i;
        c=j;
        // Diagonal right up
        while(r >= 0 && c < m)
        {
            if(grid[r][c] == 1)
                return false;
            r--;
            c++;
        }
        return true;
    }
}