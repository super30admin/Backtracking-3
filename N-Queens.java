// TC: O(N!)
// SC: O(1)
// Did it successfullt run in Leetcode? : Yes
class Solution {
    int[][] board;
    int m;
    List<List<String>> result;
     public List<List<String>> solveNQueens(int n) {
        m = n;
        board = new int[n][n];
        result = new ArrayList();
        backtrack(0);
        return result;
    }
    private void backtrack(int r)
    {
        // base
        if (r == m)
        {
            List<String> list = new ArrayList();
            for ( int i = 0; i < m; i++)
            {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++)
                {
                    if (board[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        
        // logic
        // iterate over the column
        for ( int j = 0; j < m; j++)
        {
           // System.out.print("I am inside for loop");
            if (isSafe(r, j))
            {
                //action
                board[r][j] = 1;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][j] = 0;
            }     
        }
    }
    private boolean isSafe(int r , int c)
    {
        // column cells that are above the current row i
        for ( int k = 0; k < r; k++){
            if (board[k][c] == 1)
                return false;
        }
        // diagonal up left
        int i = r; int j = c;
        while ( i >=0 && j >= 0){
           if (board[i][j] == 1)
               return false;
            i--;
            j--;
        }
        //  diagonal up right
         i = r;  j = c;
        while ( i >= 0 && j < m){
           if (board[i][j] == 1)
               return false;
            i--;
            j++;
        }
        return true;
    }
}
