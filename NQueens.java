//o(n!) time and o(n^2) space
//passed all leetcode cases
//used backtracking approach discussed in class
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[][]board = new int [n][n];
        placeQueens(board,0,n);
        return result;
    }
    private void placeQueens(int[][]board, int r,int n){

        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==1)sb.append("Q");
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(board,r,i,n)){
                board[r][i]=1;
                placeQueens(board,r+1,n);
                board[r][i]=0;
            }
        }

    }
    private boolean isValid(int[][]board, int r,int c, int n){
        for(int i=0;i<r;i++){
            if(board[i][c]==1) return false;
        }
        int i=r-1;int j=c-1;
        while(i>=0&&j>=0){
            if(board[i][j]==1) return false;
            i--;j--;
        }
        i=r-1; j=c+1;
        while(i>=0&&j<n){
            if(board[i][j]==1) return false;
            i--;j++;
        }
        return true;
    }
}