// Time Complexity : O(n!) 
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
  List<List<String>> result;
  int[][] board;

  public List<List<String>> solveNQueens(int n) {
    result = new ArrayList<>();
    board = new int[n][n];
    if (n == 0)
      return result;
    backtrack(0, n);

    return result;
  }

  private void backtrack(int row, int n) {
    if (row == n) {
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          if (board[i][j] == 1) {
            sb.append("Q");
          } else {
            sb.append(".");
          }
        }
        temp.add(sb.toString());
      }
      result.add(temp);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (safemove(row, i, n)) {
        board[row][i] = 1;
        backtrack(row + 1, n);
        board[row][i] = 0;
      }
    }
  }

  private boolean safemove(int row, int col, int n) {
    // same col

    for (int i = row; i >= 0; i--) {
      if (board[i][col] == 1)
        return false;
    }
    int i, j;
    // upper left
    i = row;
    j = col;
    while (i >= 0 && j >= 0) {
      if (board[i][j] == 1)
        return false;
      i--;
      j--;
    }

    // upper right
    i = row;
    j = col;
    while (i >= 0 && j < n) {
      if (board[i][j] == 1)
        return false;
      i--;
      j++;
    }
    return true;
  }
}