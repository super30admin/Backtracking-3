//Time Complexity: O(N * N!) – because there are N! possible queen placements and each safety check takes O(N).
//Space Complexity: O(N^2) for board + recursion)

//Place queens column by column using backtracking, trying each row in the current column.
//For each placement, check if it is safe (no queen in same row, upper-left diagonal, or lower-left diagonal).
//If valid, recurse to the next column; when all columns are filled, add the board configuration to results.

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int col, int n){
        if(col == n){
            List<String> li = new ArrayList<>();
            for(int r = 0; r < n; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < n; c++){
                    if(board[r][c]){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        for(int i = 0; i < n; i++){
            if(isSafe(board, i, col, n)){
                board[i][col] = true;
                helper(board, col + 1, n);
                board[i][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c, int n){
        int i = r, j = c;
        while(j >= 0){
            if(board[i][j]) return false;
            j--;
        }
       
        i = r; j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--; j--;
        }

        i = r; j = c;
        while(i < n && j >= 0){
            if(board[i][j]) return false;
            i++; j--;
        }

        return true;
    }
}
