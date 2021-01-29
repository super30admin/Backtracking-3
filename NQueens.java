// Time Complexity : N! (for 1st row N choices, 2nd row N-2/N-3 choices and so on)
// Space Complexity : N^2 (board array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class NQueens {
    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new int[n][n];

        backtrack(0);
        return result;
    }

    private void backtrack(int r){
        if(r == m){
            List<String> tmpList = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j] == 1)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                tmpList.add(sb.toString());
            }
            result.add(tmpList);
            return;
        }

        for(int j=0;j<m;j++){
            if(isSafe(r,j)){
                board[r][j] = 1;
                backtrack(r+1);
                board[r][j] = 0;
            }
        }
    }

    private boolean isSafe(int r, int c){
        //check if same column is occupied
        for(int k=0;k<r;k++){
            if(board[k][c] == 1)
                return false;
        }

        //check if left diagonal is occupied
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }

        //check if right diagonal is occupied
        i=r; j=c;
        while(i>=0 && j < m){
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }

        return true;
    }
}