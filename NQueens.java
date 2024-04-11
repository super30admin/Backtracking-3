//SC: O(n^2) -> O(n*n + n) for stack and for board
//TC: O(n!)
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0,n);  
        return result;      
    }
    private void helper(boolean[][] board , int r, int n){
        //base
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i< n ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n ; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //logic
        for(int c = 0; c<n ; c++){
            if(isSafe(board, r, c, n)){
                //action
                board[r][c] = true;
                //recurse
                helper(board, r+1, n);
                //backtrack
                board[r][c] = false;

            }
        }
    }

    private boolean isSafe(boolean[][] board , int r, int c, int n){
        //coulmn up
        for(int i =0; i< r ; i++){
            if(board[i][c]) return false;
        }
        int i = r;
        int j = c;
        while(i>=0 && j<n){
            if(board[i][j])return false;
            i--; j++;
        }
        i=r; j=c;
        while(i>=0 && j>=n){
            if(board[i][j])return false;
            i--; j--;
        }
        return true;
    }
}