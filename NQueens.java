/*
Desc : We check for every position of Queen in the board at every row ,
whenever all th equeens are not able to accomodate, we backtrack and re position the queen at base level.
Time Complexity : O(n!)
Space Complexity : O(1)
*/


class Solution {
    List<List<String>> result;
    int [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        backtrack(0,n);
        return result;
    }
    private void backtrack(int r,int n){
        //base
        if(r==n){
            List<String> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){//if queen present
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            result.add(res);
        }
        //logic
        for(int c=0;c<n;c++){
            if(isSafe(r,c,n)){
                board[r][c] = 1;
                backtrack(r+1,n);
                board[r][c] = 0;
            }
        }
    }
    private boolean isSafe(int r,int c,int n){
        //check. column up
        for(int i=0;i<r;i++){
            if(board[i][c]==1) return false;
        }
        //diagonal up right
        int i=r;
        int j=c;
        while(i>=0 && j<n){
            if(board[i][j]==1) return false;
            i--; j++;
        }
        //diagonal left
        i=r;
        j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--; j--;
        }
        return true;
    }
}
