// Queens 

//Time n factorial, n is the given i/p
//space o(n pow 2) => board size and recursive stack size is o(n) which is neglible when compared n pow 2.
class Solution {
    List<List<String>> res;
    int[][] board;
    int entries;
    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        res = new ArrayList<>();
        entries = n;
        placeQueens(0);
        return res;
    }
    
    private void placeQueens(int row) {
        
        //base case
        if(row == entries) {
            List<String> list = new ArrayList<>();
            for(int r=0;r<entries;r++) {
                StringBuilder sb = new StringBuilder();
                for(int c=0;c<entries;c++) {
                    if(board[r][c] == 1)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        //logic
        for(int c=0;c<entries;c++) {
            if(isSafe(row,c)) {
                //action
                board[row][c] = 1;
                //recurse
                placeQueens(row+1);
                //backtrack
                board[row][c] = 0;
            }
        }
    }
    
    private boolean isSafe(int r, int c) {
        //check on the Top column
        for(int k=0;k<r;k++){
            if(board[k][c] == 1)
                return false;
        }
        //check diagnolly left
        int i=r-1, j=c-1;
        while(i>=0 && j>=0) {
            if(board[i][j] == 1)
                return false;
            i--;j--;
        }
        //check diagnolly right
         i=r-1; j=c+1;
        while(i>=0 && j<entries) {
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }
}