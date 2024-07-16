// Time Complexity : O(4^l), l-length of word
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
  List<List<String>> result;
  boolean[][] grid;
  int n;
  public List<List<String>> solveNQueens(int n) {
    if(n == 0) return new ArrayList<>();
    result = new ArrayList<>();
    grid = new boolean[n][n];
    this.n = n;
    backtrack(0);
    return result;
  }

  void backtrack(int row) {
    // Base
    if(row == n) {
      List<String> newList = new ArrayList<>();
      for(int i = 0; i<n; i++) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<n; j++) {
          if(grid[i][j] == true) {
            sb.append("Q");
          }else {
            sb.append(".");
          }
        }
        newList.add(sb.toString());
      }
      result.add(newList);
      return;
    }
    // Logic
    for(int i = 0; i< n; i++) {
      if(isSafe(row, i)) {
        // Action
        grid[row][i] = true;
        // Recurse
        backtrack(row+1);
        // Backtrack
        grid[row][i] = false;
      }
    }
  }

  boolean isSafe(int row, int column) {
    // Diagonally top-left
    int i = row;
    int j = column;
    while(i>=0 && j>=0) {
      if(grid[i][j] == true) {
        return false;
      }
      i--;
      j--;
    }
    // Vertically top
    for(i = row; i>=0; i--){
      if(grid[i][column] == true) {
        return false;
      }
    }
    // Diagonally top-right
    i = row;
    j = column;
    while(i>=0 && j<n) {
      if(grid[i][j] == true) {
        return false;
      }
      i--;
      j++;
    }

    return true;
  }
}