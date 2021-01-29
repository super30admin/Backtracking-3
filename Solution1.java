//Time Complexity: o(n!)
//space: o(n^2) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<String>> res;
    int row; int col;
    int[][] mat;
    public List<List<String>> solveNQueens(int n) {
        mat = new int[n][n];
        res = new ArrayList<>();
        row = col = n;
        
        helper(mat, 0);
        return res;
    }
    private void helper(int[][] mat, int r)
    {
        if( r == row )
        {
            List<String> result = new ArrayList<>();
            for(int i = 0; i<row; i++)
            {
                StringBuilder str = new StringBuilder();
                for(int j=0; j<col; j++)
                {
                    if(mat[i][j] == 1)
                        str.append('Q');
                    else
                        str.append('.');
                }
                result.add(str.toString());
            }
            res.add(result);
            return;
        }
        
        
        if(r<row)
        {
            for(int c = 0; c< col; c++)
            {
                if(isvalid(r, c))
                {
                    mat[r][c] = 1;
                    helper(mat, r+1);
                    mat[r][c] = 0;
                }
            }
        }
    }
    private boolean isvalid(int r, int c)
    {
        //dia up left
        int i = r; int j = c;
        while(i>=0 && j>=0)
        {
            if(mat[i][j] == 1)
                return false;
            i--;
            j--;
        }
        
        //diagonal up right
        i = r; j = c;
        while(i>=0 && j<col)
        {
            if(mat[i][j] == 1)
                return false;
            i--;
            j++;
        }
        
        //col
        for(i=r; i >=0; i--)
        {
            if(mat[i][c] == 1) return false;
        }
        return true;
    }
}