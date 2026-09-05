//Time Complexity: O(n * n!)
//Space Complexity: O(n) + O(n x n)
class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n)
    {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int i, int n)
    {
        //base case
        if(i == n)
        {
            List<String> list = new ArrayList<>();
            for(int r = 0; r < n; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < n; c++){
                    if(board[r][c])
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        // Traverse through the column j for the row i    
        for(int j = 0; j < n; j++)
        {
            //Validate if a queen can be placed in the position (i, j)
            if(isValid(i, j, n))
            {
                //action
                board[i][j] = true;

                //recurse
                helper(i+1, n);

                //backtrack
                board[i][j] = false; //To reset the queen when recursion is going back
            }
        }
    }

    private boolean isValid(int i, int j, int n)
    {
        int r = i; int c = j;

        //all above rows in the same column
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }

        //all diagonal up left cells
        r = i; c = j;
        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--; c--;
        }

        //all diogonal up right cells
        r = i; c = j;
        while(r >= 0 && c < n){
            if(board[r][c]) return false;
            r--; c++;
        }
        return true;
    }
}