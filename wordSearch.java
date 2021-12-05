// Time Complexity : O(m * n * 3^L) --> O(N * 3^L)
// Space Complexity : O(L) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    private int[][] dirs;
    int rows, cols;
    public boolean exist(char[][] board, String word) {
        
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        
        dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        rows = board.length;
        cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTrack(board, i , j , 0, word)) return true;
            }
        } 
        
        return false;
    }
    
    private boolean backTrack(char[][] board, int row, int col, int index, String word) {
        //base
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == '#') {
            return false;
        }
        //logic
        if (board[row][col] == word.charAt(index)) {
            //action
            char c = board[row][col];
            board[row][col] = '#';
            //recurse
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (backTrack(board, newRow, newCol, index + 1, word)) return true;
  
            }
           //backtrack
            board[row][col] = c;

        }
        return false;
        
    }
}