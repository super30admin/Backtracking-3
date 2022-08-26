import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n!) where n = number of queens
// Space Complexity : O(n*n) where n = number of queens
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//51. N-Queens (Hard) - https://leetcode.com/problems/n-queens/
class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        
        if (n == 0) return result;
        
        boolean[][] board = new boolean[n][n]; // O(n*n) space
        backtrack(board, 0); // O(n) space
        
        return result;
    }
    
    private void backtrack(boolean[][] board, int column) {
        // base
        if (column == board.length) {
            List<String> list = new ArrayList<>();
            
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                
                list.add(sb.toString());
            }
            
            result.add(list);
            return;
        }
        
        // logic
        for (int row = 0; row < board.length; row++) {
            if (isValid(board, row, column)) {
                // action
                board[row][column] = true;
                
                // recurse
                backtrack(board, column + 1);
                
                // backtrack
                board[row][column] = false;
            }
        }
    }
    
    private boolean isValid(boolean[][] board, int row, int column) {
        // check for any queen in same row
        for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            if (board[row][columnIndex]) return false;
        }
        
        // check for any queen in diagonal from bottom right to top left
        for (int rowIndex = row, columnIndex = column; rowIndex >= 0 && columnIndex >= 0; rowIndex--, columnIndex--) {
            if (board[rowIndex][columnIndex]) return false;
        }
        
        // check for any queen in diagonal from top tight to bottom left
        for (int rowIndex = row, columnIndex = column; rowIndex < board.length && columnIndex >= 0; rowIndex++, columnIndex--) {
            if (board[rowIndex][columnIndex]) return false;
        }
        
        // if nothing is false, then the place is valid
        return true;
    }
}