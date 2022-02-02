// Time Complexity : O(n!)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> result;
    boolean [][] board;
    int N;
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        N = n;
        result = new ArrayList<>();
        backtrack(0);
        return;
    }
    
    private void backtrack(int i){
        // base
        if(i == N){
            List<String> li = new ArrayList<>();
            for(int k = 0; k < N; k++){
                StringBuilder sb= new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[k][j]){
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
        for(int j = 0; j < N; j++){
            if(isSafe(i, j)){
                // action
                baord[i][j] = true;
                
                // recurse
                backtrack(i+1);
                
                // backtrack
                board[i][j] = false;
            }
        }        
    }
    
    private boolean isSafe(int r, int c){
        // check for column up
        for(int i = 0; i <= r; i++){
            if(board[i][c]) return false;
        }
        
        // diagonal left
        int i = r;
        int j = c;
        while(i >= 0 and j >= 0){
            if(board[i][j]) return false;
            i--;
            j--;
        
        // diagonal right
        i = r;
        j = c;
        while(i >= 0 and j < N){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}