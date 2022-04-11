//Time Complexity : O(n!)
//Space Complexity : O(n)

class Solution {

    //global variables for recursion
    List<List<String>> result;
    int m;
    boolean[][] board; //bad way - better put in argument of functions

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList();

        if(n==0)
            return result;

        m = n;
        board = new boolean[n][n];

        helper(0);

        return result;
    }

    //only argument we need is row that we are conisdering in one recursive call
    private void helper(int r)
    {
        //base
        //rows are over : found a solution
        if(r == m)
        {
            //make a list for current solution : each soultion will be a list of strings
            List<String> li = new ArrayList();
            //traverse the board to put each row string in li
            for(int i=0; i<m; i++)
            {
                //each row will be a string
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<m; j++)
                {
                    if(board[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                //add string to li
                li.add(sb.toString());
            }
            //add current solution (list of strings) to result
            result.add(li);
            return;
        }

        //logic
        //for current row r, we iterate over all the cols to find a cell
        for(int j=0; j<m; j++)
        {
            if(isSafe(r,j))
            {
                //action - place queen since it is safe in this cell
                board[r][j] = true;
                //recurse - go to next row
                helper(r+1);
                //backtrack - remove queen placed in current row
                board[r][j] = false;
            }
        }
    }

    //check if current cell is safe or not
    private boolean isSafe(int r, int c)
    {
        //we only need to check the col: we know current row has not been used before
        //we only need to check upper part of col: we know any further rows have not been touched yet
        for(int i=0; i<r; i++)
        {
            if(board[i][c])
                return false;
        }

        //we need to check upper right diagonal
        int i=r; int j=c; //pointers
        while(i>=0 && j<m)
        {
            if(board[i][j])
                return false;
            i--;
            j++;
        }

        //we need to check upper left diagonal
        i=r; j=c;

        while(i>=0 && j>=0)
        {
            if(board[i][j])
                return false;
            i--;
            j--;
        }

        return true;

    }
}
