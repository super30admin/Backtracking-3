// Time Complexity: O(N!)
//   - For each row, placing a queen in N columns, and recursively repeat for the next rows
//   - At worst, this gives N choices at first row, N−1 at second, ..., down to 1 at last row
//      => O(N!)
// Space Complexity: O(N^2)
//   - O(N^2) space for the board (boolean[][] board)
//   - O(N) stack space for recursive call depth
//   - O(N^2) for storing each solution (List<String> of N strings, each of size N)

// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Use backtracking to place one queen per row
// - For each row, try placing a queen in each column (0 to N-1)
//   - Before placing, call `isValid()` to ensure no queen can attack this position (check column and diagonals above)
// - If valid, place the queen and recurse to next row
// - If a solution is found (row == N), convert the board into a list of strings and add to the result
// - After exploring each column, backtrack by removing the queen and trying the next position

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    private void helper(boolean[][] board, int row, int n){
        // Base case: if we've placed queens on all rows, add board to result
        if(row == n){
            List<String> list = new ArrayList<>();
            // Convert the boolean board into a list of strings
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

        // Try placing a queen in each column of the current row
        for(int j=0; j<n; j++){
            // Check if it's valid to place a queen at (row, j)
            if(isValid(board,row,j,n)){
                // Action: Place queen
                board[row][j] = true;
                // Recurse to next row
                helper(board,row+1,n);
                // Backtrack: remove queen
                board[row][j] = false;
            }
        }
    }

    private boolean isValid(boolean[][] board,int row, int col, int n){
        int r = row;
        int c = col;

        // Check column above
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }

        r = row;
        c = col;
        // Check top Diagonal left
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        // Check top Diagonal right
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--;
            c++;
        }

        return true;
    }
}