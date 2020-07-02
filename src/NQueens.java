// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/n-queens/
 * 
 *
 */
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0) return res;
        
        boolean[][] board = new boolean[n][n];
        
        backtrack(board, n, 0);
        
        return res;
    }
    
    private void backtrack(boolean[][] board, int n, int index) {
        //base
        if(index == n){
            
            List<String> temp = new ArrayList<>();
            
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++) {
                if(board[i][j]){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
                temp.add(sb.toString());
            }
            
            res.add(temp);
            return;
        }
        
       
            for(int j=0;j<n;j++) {
                
                if(isSafe(index,j,board)) {
                    //action
                    board[index][j] = true;
                    //recurse
                    backtrack(board,n,index+1);
                    //backtrack
                    board[index][j] = false;
                }
            }

    }
    
    private boolean isSafe(int r, int c, boolean[][] board){
        
        for(int i = r-1; i>=0 ; i--){
            if(board[i][c]) return false;
        }
        
        int i = r-1, j = c-1;
        
        while(i >=0 && j >=0){
             if(board[i][j]) return false;
            i--;j--;
        }
        
        i = r-1; j = c+1;
        
        while(i >=0 && j < board.length){
             if(board[i][j]) return false;
            i--;j++;
        }
        return true;
    }
}