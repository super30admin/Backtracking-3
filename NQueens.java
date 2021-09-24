   
/* Time Complexity :  O(n!)
   Space Complexity :   O(n*n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
   Approach:
   Here we will be iterating over the chess board and check whether the given position is safe or not . 
    if
       the position is safe we will place the queen over there 
    else 
       we will come back and recheck for the previously placed queens because 
    if 
        we are at a position which is not a correct place for the queen then that means the previously placed queens were not a correct place. 
    Hence, we will backtrack and will again place the queens.
*/
class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        board = new boolean[n][n];
        helper(0,n);
        return result;
    }
    private void helper(int row,int n){
        //base case
        if(row==n)
        {
            // to create an arraylist based on required output in the form {...Q}, [..Q..], etc
            List<String> ar = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==true){
                        sb.append('Q');
                    }
                    else
                    {
                        sb.append('.');
                    }
                }
                ar.add(sb.toString());
            }
            result.add(ar);
            return;
        }
          //recursive case
        for(int j=0;j<n;j++){
            if(isSafe(row,j,n)){
                board[row][j]=true;
                helper(row+1,n);
                board[row][j]=false;
            }
        }   
    }
    private boolean isSafe(int row, int col, int n){
    //same column
       for(int r=0;r<i;r++) //here instead of i increment r
        for(int i=row-1;i>=0;i--){
            if(board[i][col]==true)
                return false;
        }
        
         //left diagonal
        int i=row-1,j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]==true)
                return false;
            else
            {
                i--;
                j--;
            }
        }
          //right diagonal
        i=row-1;j=col+1;
        while(i>=0 && j<n){
            if(board[i][j]==true)
                return false;
            else
            {
                i--;
                j++;
            }
        }
        return true;
    }
}