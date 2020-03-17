// Time Complexity : O(n!);
// Space Complexity : O(n*n); n*n -> board dimensions + n-> stringbuilder + n-> intermediate lists. Asymptotically, space consumed will be n*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach :
// We need to consider one row at a time and start placing the queens. The queen placement will depend on the states of previously placed queens.
// We need to perform column check, diagonal check and anti-diagonal check
// Whenever placement of current queen does not seem feasible, we need to backtrack and explore other possible options.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        //result
        List<List<String>> result = new ArrayList<>();
        // create chess board
        int[][] board = new int[n][n];
        placeQueen(board, result, 0);
        return result;
    }
    
    public void placeQueen(int[][] board, List<List<String>> result, int r) {
        // base case
        if(r == board.length) {
            StringBuilder sb = new StringBuilder();
            List<String> state = new ArrayList<>();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append(".");
                }
                state.add(sb.toString());
                sb.setLength(0); // resetting the StringBuilder
            }
            result.add(state);
            return;
        }
        
        // logic
        for(int j = 0; j < board.length; j++) {
            if(isValid(board, r, j)) {
                board[r][j] = 1;
                placeQueen(board, result, r+1);
                board[r][j] = 0;
            }
        }
    }
    
    private boolean isValid(int[][] board, int i, int j) {
        // logic
        // column check
        for(int r = 0; r < i; r++) {
            if(board[r][j] == 1)
                return false;
        }
        
        // diagonal check
        for(int r = i, c = j; r > 0 && c > 0; r--, c--) {
            if(board[r-1][c-1] == 1)
                return false;
        }
        
        // anti-diagonal check
        for(int r = i, c = j; r > 0 && c < board.length-1; r--, c++) {
            if(board[r-1][c+1] == 1)
                return false;
        }
        return true;
    }
}

