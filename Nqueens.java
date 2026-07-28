// Time Complexity : O(n!) where n is the number of queens to place. This is because we are trying to place queens row by row, and for each row, we have n choices for the first queen, (n-1) choices for the second queen, and so on, leading to a factorial time complexity.
// Space Complexity : O(n^2) where n is the size of the chessboard. This is because we are using a 2D boolean array to represent the board and several 1D boolean arrays to keep track of column and diagonal conflicts.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : how to implement DP.


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    boolean[][] board;
    boolean[] colSet;
    boolean[] mainDiagSet;
    boolean[] antiDiagSet;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        this.colSet = new boolean[2*n];
        this.mainDiagSet = new boolean[2*n];
        this.antiDiagSet = new boolean[2*n];

        helper(0, n);

        return result;
    }

    private void helper(int r , int n){

        if(r == n){
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
     
        for(int c=0; c<n; c++){
            
            int md = r+c;
            int ad = r-c + n;

            if(!colSet[c]&& !mainDiagSet[md] && !antiDiagSet[ad])
            {
                colSet[c] = true;
                mainDiagSet[md] = true;
                antiDiagSet[ad] = true;

                board[r][c] = true;
                helper(r+1, n);
                board[r][c] = false;

                colSet[c] = false;
                mainDiagSet[md] = false;
                antiDiagSet[ad] = false;

            }
        }
    }
}