// Time Complexity :O(n^2 + 3n*n!) -> O(n*n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {

        this.result = new ArrayList<>();
        this.board = new boolean[n][n];

        dfs(0, n);

        return result;
    }

    private void dfs(int row, int n) {

        if(row == n) {
            List<String> temp = new ArrayList<>();
            //O(n^2)
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }

        //O(n*n!) -> 3n (n) for isSafe, n! for dfs
        for(int j=0; j<n; j++) {
            if(isSafe(row, j, n)) {
                //action
                board[row][j] = true;
                //recurse
                dfs(row+1, n);
                //backtrack
                board[row][j] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, int n) {

        int i = row-1;
        int j = col;

        while(i>=0) {
            if(board[i][j])
                return false;
            i--;
        }

        i = row-1;
        j = col-1;
        while(i>=0 && j>=0) {
            if(board[i][j])
                return false;
            i--;
            j--;
        }

        i = row-1;
        j = col+1;

        while(i>=0 && j<n) {
            if(board[i][j])
                return false;
            i--;
            j++;
        }

        return true;
    }
}