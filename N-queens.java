
class Solution {
    private List<List<String>> result;
    private boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0, n);
        return result;
    }
    private void backtrack(int i, int n){
        if(i == n){
            List<String> currStr = new ArrayList<>();
            for(int r = 0;r<n;r++){
                StringBuilder sb = new StringBuilder();
                for(int c =0;c<n;c++){
                    if(board[r][c]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                currStr.add(sb.toString());
            }
            result.add(currStr);
        }
        //logic
        for(int j =0;j<n;j++){
            if(isSafe(i,j,n)){
                //action
                board[i][j] = true;
                //recurse
                backtrack(i+1,n);
                //backtrack
                board[i][j] = false;
            }
        }
    }
    private boolean isSafe(int r,int c, int n){
        //column up
        for(int i = 0; i<r;i++){
            if(board[i][c])return false;
        }
        int i = r; int j = c;
        while(i>=0 && j>=0 ){
            if(board[i][j])return false;
            i--;
            j--;
        }
        i = r; j = c;
        while(i>=0 && j<n){
            if(board[i][j])return false;
            i--;
            j++;
        }
        return true;
    }
}