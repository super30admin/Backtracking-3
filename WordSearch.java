//Time complexity is O(N*3^L) L is length of given word, N is number of cells
//Space complexity is O(N)
class Solution {
    char[][] board;
    int ROWS;
    int COLS;

  public boolean exist(char[][] board, String word) {
    this.board = board;
    ROWS = board.length;
    COLS = board[0].length;

    for (int row = 0; row < this.ROWS; ++row)
      for (int col = 0; col < this.COLS; ++col)
        if (helper(row, col, word, 0))
          return true;
    return false;
  }

  public  boolean helper(int row, int col, String word, int index) {
    if (index >= word.length())
      return true;

    if (row < 0 || row == ROWS || col < 0 || col == COLS
        || this.board[row][col] != word.charAt(index))
      return false;

    boolean ret = false;
    board[row][col] = '#';

    int[] rows = {0, 1, 0, -1};
    int[] cols = {1, 0, -1, 0};
    for (int d = 0; d < 4; ++d) {
      ret = helper(row + rows[d], col + cols[d], word, index + 1);
      if (ret)
        break;
    }
    board[row][col] = word.charAt(index);
    return ret;
  }
}
