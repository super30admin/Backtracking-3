// Time Complexity : O(n!)
// Space Complexity : O(n) (recursion stack) + O(n^2) (boolean 2D array of size n * n to store the state)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class NQueens {
    private List<List<String>> result;
    private int row;
    private int col;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        row = n;
        col = n;
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return result;
    }

    private void backtrack(boolean[][] board, int r) {
        //base
        if(r == row) {
            List<String> solution = new ArrayList<>();
            for(int i =0; i<row; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<col; j++){
                    if(board[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }

        //logic
        for(int c=0; c<col; c++) {
            if(isSafe(board, r, c)) {
                board[r][c] = true;
                backtrack(board, r+1);
                board[r][c] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        //check for column above

        for(int i=0; i<r; i++) {
            if(board[i][c]) return false;
        }

        //check for diagonal up-left
        int i=r;
        int j=c;
        while(i>=0 && j>=0) {
            if(board[i][j]) return false;
            i--;
            j--;
        }

        //check for diagonal up-right
        i=r;
        j=c;
        while(i>=0 && j<col) {
            if(board[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }
}
