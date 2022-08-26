import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n) * 3 power k where m = number of rows, n= number of columns, k = length of word
// Space Complexity : O(k) where k = length of word
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//79. Word Search (Medium) - https://leetcode.com/problems/word-search/
class Solution {
    
    int[][] dirs;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        
        int m = board.length, n = board[0].length;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0)) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        // base
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return false;
        
        // logic
        // action
        if (word.charAt(index) == board[row][col]) {
            // action
            char temp = board[row][col];
            board[row][col] = '#';
            
            for(int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                // recurse
                if (backtrack(board, nr, nc, word, index + 1)) return true;
            }
            
            // backtrack
            board[row][col] = temp;
        }
        
        return false;
    }
}