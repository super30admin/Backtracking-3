// Time Complexity : O(n!)
// Space Complexity : O(n)

class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        if(n < 1)
            return result;
        helper(n, 0);
        return result;
    }
    
    private void helper(int n, int r){
        //base
        if(r == n){
            List<String> cur = new ArrayList<>();
            for(int i = 0;i < n;i++){
                StringBuilder str = new StringBuilder();
                for(int j = 0;j < n;j++){
                    if(board[i][j] == 1)
                        str.append("Q");
                    else
                        str.append(".");
                }
                cur.add(str.toString());
            }
            result.add(cur);
        }
        //logic
        for(int j = 0; j < n; j++){
            if(isSafe(r, j, n)){
                board[r][j] = 1;
                helper(n, r + 1);
                board[r][j] = 0;
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        //column
        for(int i = 0; i < r; i++){
            if(board[i][c] == 1)
                return false;
        }
        //diagonal left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        //diagonal right
        i = r;
        j = c;
        while(i >=0 && j < n){
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}