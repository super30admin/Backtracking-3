// Time Complexity : O(2^n)
// Space Complexity : 1 - O(n^2), 2, 3 - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
  int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
  int m, n;
  public boolean exist(char[][] board, String word) {
    if(board == null || board.length == 0 ) return false;
    m = board.length;
    n = board[0].length;
    for(int i = 0; i<m; i++) {
      for(int j = 0; j<n; j++) {
        if(board[i][j] == word.charAt(0)) {
          if(backtrack(board, word, 0, i,j)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  boolean backtrack(char[][] board, String word, int index, int row, int column) {
    // Base
    if(index == word.length()) {
      return true;
    }
    if(row>=m || row<0 || column>=n || column<0 || board[row][column] == '#') {
      return false;
    }
    // Logic
    // Action
    if(board[row][column] == word.charAt(index)) {
      char temp = board[row][column];
      board[row][column] = '#';
      // Recurse
      for(int[] dir: dirs) {
        int newX = row + dir[0];
        int newY = column + dir[1];
        if(backtrack(board, word, index+1, newX, newY)) {
          return true;
        }
      }
      // Backtrack
      board[row][column] = temp;
    }
    return false;
  }

}