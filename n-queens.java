// Time Complexity : factorial
// Space Complexity : O(nxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[][]grid;
    int n;
    public List<List<String>> solveNQueens(int n) {
        grid = new boolean[n][n];
        if(n==0)
        {
            return result;
        }
        this.n=n;
        backtracking(0);
        return result;
    }
    private void backtracking(int row)
    {
        if(row==n)
        {
            List<String> answer = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder sb= new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if( grid[i][j] == true)
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(row,i))
            {
                grid[row][i]=true;
                backtracking(row+1);
                grid[row][i]= false;
            }
        }
    }
    private boolean isSafe(int row, int col)
    {
        for(int i=row-1;i>=0;i--)
        {
            if(grid[i][col]==true){
                return false;
            }
        }
        int i=row, j=col;
        while(i>=0 && j>=0)
        {
            if(grid[i][j]==true)
            {
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<n)
        {
            if(grid[i][j]==true)
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

} 