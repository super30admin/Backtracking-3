// Time Complexity - O(n!)
// Space Complexity -  O(n^2)
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        result = new ArrayList<>();
        backtracking(n, board, 0);
        return result;
    }

    public void backtracking(int n, boolean[][] board, int r){
        if(r == n){
            // all queens placed
            List<String> rows = new ArrayList<>();
            for(int row = 0; row < n; row++){
                StringBuilder str = new StringBuilder();
                for(int col = 0; col < n; col++){
                    if(board[row][col]){
                        str.append("Q");
                    }
                    else str.append(".");
                }
                rows.add(str.toString());
            }
            result.add(rows);
            return;
        }

        for(int i = 0; i < n; i++){
            // action
            if(isSafe(board, r, i,n)){
                //action
                board[r][i] = true;
                // recurse
                backtracking(n, board, r + 1);
                // backtrack
                board[r][i] = false;
            }
            
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c, int n){
        // row directly above
        for(int i = 0; i < r; i++){
            if(board[i][c]) return false;
        }
        // left diagonal
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        // right diagonal
        i = r; j = c;
        while(i >= 0 && j < n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        // all spaces do not have a queen
        return true;
    }
}
