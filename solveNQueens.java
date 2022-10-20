class Solution {
    List<List<String>> result;
    boolean[][] grid;
    int len;
    public List<List<String>> solveNQueens(int n) {
        
        if(n==0) return result;
        len=n;
        grid=new boolean[n][n];
        result = new ArrayList<>();
        
        helper(0);
        
        return result;
        
        
    }
    
    private void helper(int level)
    {
        if(level==len)
        {
            List<String> ans=new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<len;j++)
                {
                    if(grid[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }
        
        for(int i=0;i<len;i++)
        {
            if(Safe(level,i))
            {
                grid[level][i]=true;
                helper(level+1);
                grid[level][i]=false;
            }
        }
    }
    
    private boolean Safe(int r,int c)
    {
        //up left
        for(int i=r,j=c; i>=0 && j>=0 ;i--,j--)
            if(grid[i][j])
                return false;
        
        //up right
        for(int i=r,j=c; i>=0 && j<len ;i--,j++)
            if(grid[i][j])
                return false;
        
        for(int i=r; i>=0 ;i--)
            if(grid[i][c])
                return false;
        
        return true;
        
        
        
    }
}

// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no