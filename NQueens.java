// Time Complexity : O(n^n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n==0) return result;
        int[][] board = new int[n][n];
        backtrack(0,n,result,board);
        return result;
    }
    
    private void backtrack(int row, int n, List<List<String>> result, int[][] board){
        //base case
        if(row==n){
            //Iterate through board and construct list
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==0)
                        sb.append(".");
                    else
                        sb.append("Q");
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        
        
        for(int col = 0;col<n;col++){
            if(isSafe(row,col,board)){
                board[row][col]=1;
                backtrack(row+1,n,result,board);
                board[row][col]=0;
            }
        }
    }
    
    private boolean isSafe(int r, int c,int[][] board){
        //check column
        for(int i=r-1;i>=0;i--){
            if(board[i][c]==1) return false;
        }
        //check top left diagonal
        int i = r-1; int j = c-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--;j--;
        }
        //check top right diagonal
        i = r-1; 
        j = c+1;
        while(i>=0 && j<=board.length-1){
            if(board[i][j]==1) return false;
            i--;j++;
        }
        return true;
    }
}