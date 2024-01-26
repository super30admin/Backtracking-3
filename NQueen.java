//TC = O(n*(n!))
//SC = O(m*n)

class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[][] grid; 
    public List<List<String>> solveNQueens(int n) {
        grid = new boolean[n][n];
        backtrack(0, n);
        return result;
    }

    private void backtrack(int r, int n)
    {
        //base condition
        if(r == n)
        {
            List<String> l = new ArrayList<>();
            for(int i = 0; i < n; i ++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++)
                {
                    if(grid[i][j] == true)
                    {
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            result.add(l);   
        }
    

        //action
        for(int c = 0; c < n; c++)
        {
            if(isSafe(r,c, n))
            {
                grid[r][c] = true;

                //recurse
                backtrack(r+1,n);

                //backtrack
                grid[r][c] = false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n)
    {
        //up
        for(int i = 0; i < r; i++)
        {
            if(grid[i][c]) return false; 
        }
        int i = r;
        int j = c;
        //diag up right
        while(i >=0 && j < n)
        {
            if(grid[i][j]) return false;
            i--;
            j++;
        }

        i = r;
        j = c;
        //diag up left
        while(i >=0 && j >= 0)
        {
            if(grid[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
}