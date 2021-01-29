// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<String>> result = new ArrayList<>();
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        m = n;
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    private void backtrack(int r){
        //base
        if(r == m){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < m; k++){
                    if(board[i][k] == 1)
                        sb.append('Q');
                    else 
                        sb.append('.');
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        //logic
        for(int j = 0; j < m; j++){
            if(isSafe(r, j)){
                board[r][j] = 1;
                backtrack(r+1);
                board[r][j] = 0;
            }
        }
    }
    private boolean isSafe(int x, int y){
        // column up
        for(int k = 0; k < x; k++){
            if(board[k][y] == 1)
                return false;
        }
        // diagonal up left
        int i=x; int j=y;
        while(i>=0 && j>=0){
            if(board[i][j] == 1)
                return false;
            i--;j--;
        }
        //diagonal up right
        i = x; j = y;
        while(i>=0 && j<m){
            if(board[i][j] == 1)
                return false;
            i--;j++;
        }
        return true;
    }
}