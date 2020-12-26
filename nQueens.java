// Time Complexity : exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList();
        if(n == 0)
            return result;
        board = new int[n][n];
        backtrack(0, n);
        return result;
    }
    
    public void backtrack(int row, int n) {
        
        // base
        if(row == n) {
            List<String> temp = new ArrayList();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        // logic
        for(int i = 0; i < n; i++) {
            if(isSafe(row, i, n)) {
                board[row][i] = 1;
                backtrack(row + 1, n);
                board[row][i] = 0;
            }
        }
    }
    
    public boolean isSafe(int row, int col, int n) {
        // check column
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1)
                return false;
        }
        int i = row, j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        i = row; j = col;
        while(i >= 0 && j < n) {
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
    
}