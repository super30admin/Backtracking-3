// Time Complexity: O(n!)
// Space Complexity: O(n^2) ie., no of rows * no of cols


// Approach: Start placing the queen starting from a particular row & each time check if its a valid place to keep the queen.
// If its valid then keep placing until the end of the board and backtrack to see if there are other combinations available.
class Solution {
    int m;
    List<List<String>> res;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        m=n;
        res = new ArrayList<>();
        board = new int[m][m];
        placeQueen(0);
        return res;
    }
    
    private void placeQueen(int row) {
        //base
        if(row == m) { // if we reached end of board
            List<String> ls = new ArrayList<>();
            for(int i=0;i<m;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    if(board[i][j]==0) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                ls.add(sb.toString());
            }
            res.add(ls);
        }
        // logic
        for(int i=0;i<m;i++) {
            if(isSafe(row,i)) {
                board[row][i]=1; // action
                placeQueen(row+1); // recurse
                board[row][i]=0; // backtrack
            }
        }
    }
    // checks if queen can be placed at particular position
    private boolean isSafe(int r,int c) {
        // column
        for(int i=0;i<=r;i++) {
            if(board[i][c]==1) return false;
        }
        // up right diagonal
        int upRightRow = r-1, upRightCol = c+1;
        while(upRightRow >= 0 && upRightCol < m) {
            if(board[upRightRow][upRightCol] == 1) return false;
            upRightRow--; upRightCol++;
        }
        // up left diagonal
        int upLeftRow = r-1, upLeftCol = c-1;
        while(upLeftRow >= 0 && upLeftCol >= 0) {
            if(board[upLeftRow][upLeftCol] == 1) return false;
            upLeftRow--; upLeftCol--;
        }
        
        return true;
    }
}