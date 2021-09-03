/* Time Complexity :  O(n!)
   Space Complexity :   O(n*n)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
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
        if(row==n)
        {
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
        for(int j=0;j<n;j++){
            if(isSafe(row,j,n)){
                board[row][j]=true;
                helper(row+1,n);
                board[row][j]=false;
            }
        }   
    }
    private boolean isSafe(int row, int col, int n){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]==true)
                return false;
        }
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