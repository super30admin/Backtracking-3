/**** Solution ****/
//Time Complexity: O(n!)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

// To find the solution, a valid queens placement, we try to move each and every row  and column and check if it is possible to keep the queen over there without being attacked by other queens, if yes then we move to next row recursive functions and so on.If we reach nth row then it tell us that we found an answer, we add that to list of lists. At the end return this list of lists.

import java.util.ArrayList;
import java.util.List;

public class _51_N_Queens {

  public static void main(String[] args) {}

  public List<List<String>> totalNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    boolean[][] board = new boolean[n][n];

    totalNQueens(0, n, board, ans);

    return ans;
  }

  private void totalNQueens(
    int idx,
    int n,
    boolean[][] board,
    List<List<String>> ans
  ) {
    if (idx == n) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          if (board[i][j]) {
            sb.append("Q");
          } else {
            sb.append(".");
          }
        }
        list.add(sb.toString());
      }

      ans.add(list);
      return;
    }

    for (int j = 0; j < n; j++) {
      board[idx][j] = true;
      if (isPossible(idx, j, n, board)) {
        totalNQueens(idx + 1, n, board, ans);
      }
      board[idx][j] = false;
    }
  }

  private boolean isPossible(int i, int j, int n, boolean[][] board) {
    for (int r = i - 1; r >= 0; r--) {
      if (board[r][j]) return false;
    }
    for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
      if (board[r][c]) return false;
    }

    for (int r = i - 1, c = j + 1; r >= 0 && c < n; r--, c++) {
      if (board[r][c]) return false;
    }
    return true;
  }
}
