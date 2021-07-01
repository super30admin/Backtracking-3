class Solution {
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        helper(0,n);
        return result;
    }
    
    private void helper(int r, int n){
        if(r == n){
            returnResult(board,n);
        }
        
        for(int j=0; j<n; j++){
            if(isSafe(r,j,n)){
                //action
                board[r][j] = 1;
                //recurse
                helper(r+1, n);
                //backtrack
                board[r][j] = 0;
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        for(int i=0; i<r; i++){
            if(board[i][c] == 1) return false;
        }
        int i=r; int j=c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;j--;
        }
        i=r; j=c;
        while(i >= 0 && j < n){
           if(board[i][j] == 1) return false;
           i--;j++; 
        }
        return true;
    }
    
    private void returnResult(int[][] board,int n){
        List<String> li = new ArrayList();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(board[i][j] == 1) sb.append('Q');
                else sb.append('.');
            }
            li.add(sb.toString());
        }
        result.add(li);
    }
}