// Time Complexity : O(N*M) 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Add the queen at a position.
2. Check if the position is fine. If yes keep it if not change it.
3. If we don;t get any good position for our current position then backtrack and change the previsous posiiton.
*/


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        backtrack(0, n);
        return result;
    }
    
    public void backtrack(int r, int  n) {
        if(r == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                String row = "";
                for(int j=0;j<n;j++) {
                    if(board[i][j] == 0) row += ".";
                    else if(board[i][j] == 1) row += "Q";
                }
                temp.add(row);
            }
            result.add(temp);
            return;
        }
        
        for(int i=0;i<n;i++) {
            // System.out.println(isSafe(r, i, n));
            if(isSafe(r, i, n)) {
                board[r][i] = 1;
                backtrack(r+1, n);
                board[r][i] = 0;
            }
        }
    }
    
    public boolean isSafe(int r, int c, int n) {
        for(int i=0;i<r;i++) {
            if(board[i][c] == 1) return false;
        }
        int i = r; int j = c;
        while(i>=0 && j>=0) {
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        i = r; j = c;
        while(i>=0 && j<n) {
            if(board[i][j] == 1) return false;
             i--; j++;
        }
       return true; 
    }
}
