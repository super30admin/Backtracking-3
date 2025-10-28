// Time Complexity : O(n * n!)
// Space Complexity : O(n^2)  + O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int row, int n){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }

            result.add(list);
            return;
        }

        for(int j=0; j<n; j++){
            if(isValid(board, row, j, n)){
                board[row][j] = true;
                helper(board, row+1, n);
                board[row][j] = false;
            }
        }
    }

    private boolean isValid(boolean[][] board, int i, int j, int n){
        int r = i, c = j;
        while(r >=0){
            if(board[r][c]) return false;
            r--;
        }

        r = i; c = j;
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--; c--;
        }

        r = i; c = j;
        while(r>=0 && c < n){
            if(board[r][c]) return false;
            r--; c++;
        }

        return true;
    }
}
