// Time Complexity : O(n!)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean [n][n];
        dfs(0);
        return result;
    }
    private void dfs(int row){
        // base
        if(row == board.length){
            List<String> li = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j< board.length; j++){
                    if(board[i][j] == true){
                        sb.append('Q');
                    } else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        
        // logic
        for(int j=0; j< board[0].length; j++){
            if(isSafe(row, j)){
                // action
                board[row][j] = true;
                // recursion
                dfs(row+1);
                // backtracking
                board[row][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c ){
        // column check
        for(int i=0; i<r; i++){
            if(board[i][c] == true) return false;
        }
        // diagonal up left
        int i=r; int j=c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == true) return false;
            i--; j--;
        }
        // diagonal up right
        i=r; j=c;
        while(i >= 0 && j < board.length){
            if(board[i][j] == true) return false;
            i--; j++;
        }
        return true;
    }
    
}