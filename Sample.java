// Problem 1 - N-Queens
// Time Complexity: O(n*m + m*n)
// Space Complexity: O(n*n)

// Algorithm
// 1 - create a board initially with empty cells
// 2 - call backtracking with initial values
// 3 - base condition check if queensleft is less than or equal to 0
// 4 - if yes, add the converted list of string to output
// 5 - loop over column
// 6 - check for valid cell
// 7 - check for upper column cells
// 8 - check for left diagonal
// 9 - check for right diagonal
// 10 - if valid, replace cell with Queen
// 11 - call backtracking
// 12 - replace cell with empty cell
class Solution {
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    // 1
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        board[i][j] = '.';
      }
    }

    List<List<String>> output = new ArrayList<>();
    // 2
    backtracking(output, board, n, 0);

    return output;
  }

  private void backtracking(List<List<String>> output, char[][] board, int queensLeft, int i) {
    // 3
    if (queensLeft <= 0) {
      // 4
      output.add(getOutput(board));
      return;
    }
    // 5
    for (int j=0; j<board.length; j++) {
      // 6
      if (isValid(board, i, j)) {
        // 10
        board[i][j] = 'Q';
        // 11
        backtracking(output, board, queensLeft - 1, i + 1);
        // 12
        board[i][j] = '.';
      }
    }
  }

  private List<String> getOutput(char[][] board) {
    List<String> list = new ArrayList<>();
    for (int i=0; i<board.length; i++) {
      String s = "";
      for (int j=0; j<board[0].length; j++) {
        s += board[i][j];
      }
      list.add(s);
    }

    return list;
  }

  private boolean isValid(char[][] board, int i, int j) {
    int r = i;
    int c = j;
    // 7
    while (r >= 0) {
      if (board[r][c] == 'Q') {
        return false;
      }
      r--;
    }

    r = i;
    c = j;
    // 8
    while (r >= 0 && c >= 0) {
      if (board[r][c] == 'Q') {
        return false;
      }
      r--;
      c--;
    }

    r = i;
    c = j;
    // 9
    while (r >= 0 && c < board.length) {
      if (board[r][c] == 'Q') {
        return false;
      }
      r--;
      c++;
    }

    return true;
  }
}

// Problem 2 - Word Search
// Time Complexity: O(n * m)
// Space Complexity: O(1)

// Algorithm
// 1 - initialiaze directions array
// 2 - loop over board
// 3 - if cell matches with first character, call backtracking
// 4 - check for base condition
// 5 - store the current character
// 6 - replace with special character
// 7 - loop over directions array
// 8 - get row and column index
// 9 - check for out of bounds and if cell matches with character
// 10 - call backtracking
// 11 - restore the stored character
class Solution {
  // 1
  int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public boolean exist(char[][] board, String word) {
    // 2
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        // 3
        if (board[i][j] == word.charAt(0)) {
          if (backtracking(board, word, i, j, 0)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private boolean backtracking(char[][] board, String word, int i, int j, int index) {
    // 4
    if (index >= word.length() - 1) {
      return true;
    }
    // 5
    char temp = board[i][j];
    // 6
    board[i][j] = '#';
    // 7
    for (int[] dir : dirs) {
      // 8
      int r = dir[0] + i;
      int c = dir[1] + j;
      // 9
      if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (index + 1 < word.length() && word.charAt(index + 1) == board[r][c])) {
        // 10
        if (backtracking(board, word, r, c, index + 1)) {
          return true;
        }
      }
    }
    // 11
    board[i][j] = temp;

    return false;
  }
}
