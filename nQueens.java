//TC : Exponential / O(n!)
//SC : O(N)
class Solution {
    boolean[][] grid;
    List <List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return result;
        grid = new boolean[n][n];
        helper(0);
        return result;
    }

    private void helper(int row){
        //base
        if(row==grid.length)
        {
            List<String> l = new ArrayList<>();
            for(int i=0;i<grid.length;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<grid.length;j++)
                {
                    if(grid[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');

                }
                l.add(sb.toString());
            }
            result.add(l);
        }
        //logic

        for(int i=0;i<grid.length;i++)
        {
            if(isSafe(row,i))
            {
                grid[row][i] = true;
                helper(row+1);
                grid[row][i] = false;
            }

        }
    }

    private boolean isSafe(int r, int c)
    {
        for(int i=0;i<r;i++)
        {
            if(grid[i][c])
                return false;
        }
        int row =r;
        int col =c;
        while(col<grid.length&&row>=0)
        {
            if(grid[row][col])
                return false;

            row--;
            col++;
        }
        row=r;
        col=c;
        while(row>=0&&col>=0)
        {
            if(grid[row][col])
                return false;
            row--;
            col--;
        }
        return true;
    }
}