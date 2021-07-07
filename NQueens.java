/*
Time: O(N!) ==> N, N(N-2), N(N-2)(N-4) for first, second and third rows etc..
Space: O(N^2)
Algorithm:
========
1. In every row, for every column, check if queen can be placed in that column by checking diagonals on both sides and rows above
2. If reached last row, implies valid solution found, else fails somewhere
3. If found, add it to the result list
*/
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        backtrack(new int[n][n], n, 0);
        return result;
    }
    
    private void backtrack(int[][] board, int n, int row) {
         //base
        if(row == n) {
            List<String> state = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                //Update values in list as per result format
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 1) 
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                state.add(sb.toString());
            }
            result.add(state);
        }
        //logic 
        for(int i = 0; i < n; i++) {    // For possibility of placing queen in every column
            if(isValid(board, row, i)) {
                board[row][i] = 1;  //action
                backtrack(board, n, row+1); //recurse (increment row)
                board[row][i] = 0; //backtrack
            }
        }
    }
    
    //check validity of placing queen at current row and column
    private boolean isValid(int[][] board, int row, int col) {
        // top rows same column check if queen is already present
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 1) return false;
        }
        
        //check if queen is present on digonal left
        int i = row - 1, j = col - 1;
        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        
        //check if queen is already present on diagonal right
        i = row - 1; j = col + 1;
        while(i >= 0 && j < board.length) {
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}