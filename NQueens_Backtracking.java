/* Time Complexity : O(n!) - n factorial
 * Space Complexity : O(n^2), for board, O(n), for recursive stack
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        //null
        if(n == 0) return result;
        boolean [][] board = new boolean[n][n]; //space - n^2
        backtrack(board, 0, n);
        return result;
    }
    private void backtrack(boolean [][] board, int r, int n){
        //base
        //[".Q.."
        //"...Q"
        //"Q..."
        //"..Q."]
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j = 0; j < n; j++){
            if(isSafe(board, r, j, n)){
                //action
                board[r][j] = true;
                //recurse
                backtrack(board, r+1, n);
                //backtrack
                board[r][j] = false;
            }
        }
    }
    private boolean isSafe(boolean [][] board, int r, int c, int n){
        //up column
        for(int i = 0; i < r; i++){
            if(board[i][c]) return false;
        }
        //diagonal up left
        //while r--, c-- - if we use these, we will loose initial coordinates.
        //So using 2 variables i & j to store r & c for decrementing for going to top                 //left diagonal cells in upper rows.
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        //diagonal up right
        //resetting i & j to r & c (original) to check top right diagonal cells in upper             //rows.
        i = r;
        j = c;
        while(i >= 0 && j < n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
