// Time Complexity : O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For each row we can place the queen in all possible safe squares.
    We compute the safe square based on the both the diagnols and that particular column.
*/

class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        backtrack(0,n);
        return result;
    }
    
    public void backtrack(int r, int n){
        
        if (r==n){
            List<String> li = new ArrayList<>();
            for (int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++){
                    if (board[i][j] == 1)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        
        for (int i=0; i<n; i++){
            
            if (isSafe(r,i,n)){
                board[r][i]=1;
                backtrack(r+1,n);
                board[r][i]=0;
            }
        }
    }
    
    public boolean isSafe(int r, int c, int n){
        
        for (int i=0; i<r; i++){
            if(board[i][c]==1) return false;
        }
        
        int i,j;
        i=r;
        j=c;
        while(i>=0 && j<n){
            if(board[i][j]==1) return false;
            i--;
            j++;
        }
        
        i=r;
        j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--;
            j--;
        } 
        
        return true;
    }
    
}