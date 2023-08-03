// Time Complexity : O(n!), where n is the number of rows and columns in the board.
// Space Complexity : O(n^2), where n is the number of rows and columns in the board.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Place the queen in the first row and first column and check if it is safe to place the queen.
 * 2. If it is safe, place the queen and move to the next row.
 * 3. If it is not safe, move to the next column and check if it is safe to place the queen.
 * 4. When we reach the last row and there are no valid options to place the queen, backtrack to the previous row and check if it is safe to place the queen.
 * 5. When we reach the index to n, then add the board to the result.
 * 6. Build the valid board from the boolean board.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        helper(board, 0, result);
        return result;
    }

    private void helper(boolean[][] board, int row, List<List<String>> result){
        if(row == board.length){
            List<String> validBoard = new ArrayList<>();
            validBoard = createValidBoard(board);
            result.add(validBoard);
            return;
        }

        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                helper(board, row+1, result);
                board[row][col] = false;
            }
        }
    }

    private List<String> createValidBoard(boolean[][] board){
        List<String> result = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();

            for(int j=0; j<board.length; j++){
                if(board[i][j] == true){
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }

            result.add(sb.toString());
        }
        return result;
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        for(int i=0; i<=row; i++){
            if(board[i][col])
                return false;
        }

        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        
        r = row; 
        c = col;
        while(r >= 0 && c < board.length){
            if(board[r][c])
                return false;
            r--;
            c++;
        }

        return true;
    }
}