// Time Complexity :Exponential
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m=n;
        boolean[][] board = new boolean[n][n];
        if(n==0){
            return result;
        }
        helper(board, 0);
        return result;
    }
    
    private void helper(boolean[][] board, int r){
        //base
        if(r==m){
            List<String> path = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                path.add(sb.toString());
            } 
            result.add(path);
            return;
        }
        
        //logic
        for(int c=0;c<m;c++){
             if(isSafe(board, r, c)){
                 board[r][c] = true;
                 helper(board, r+1);
                 board[r][c] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c){
        for(int i=0;i<r;i++){
            //same col up
            if(board[i][c]){
                return false;
            }
        }
        // diagonal left up
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;                    
            }
            i--;
            j--;
        }
        //diagonal right up
        i=r;
        j=c;
        while(i>=0 && j<m){
            if(board[i][j]){
                return false;                    
            }
            i--;
            j++;
        }
        return true;
    }
}