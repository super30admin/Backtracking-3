/**** Method 1 ****/
//Time Complexity: O(n^2 * 4^n)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

// To find the solution i.e word is present are not we have to check with starting from all the elements. So call a recursive function with all the elements as starting point, and the check if the char match the char in word if yes move ahead with all of its direction else return and move to next element. I we reach end of the word then it means we have found the word so we return true and return, and continue we there are other elements to check. To avoid infinite loop in recursion we use a temp variable to store the current element and replace it with a special character,so if know if we have already visited that element or not, and at the end we replace it with the original value.

/**** Method 2 ****/
//Time Complexity: O(n^2 * 4^n)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

// Same as for loop solution but here we call recursive function with all direction manually.

public class _79_Word_Search {

  public static void main(String[] args) {}

  public boolean exist(char[][] board, String word) {
    int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist1(i, j, 0, board, word, dir)) {
          return true;
        }
      }
    }
    return false;
  }

  /*** Method 1 ***///For Loop
  private boolean exist(
    int i,
    int j,
    int idx,
    char[][] board,
    String word,
    int[][] dir
  ) {
    if (idx == word.length()) {
      return true;
    }

    if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
      return false;
    }

    if (board[i][j] != word.charAt(idx)) {
      return false;
    }

    boolean ex = false;
    char temp = board[i][j];
    board[i][j] = '#';
    for (int arr[] : dir) {
      int nr = i + arr[0];
      int nc = j + arr[1];
      ex = ex || exist(nr, nc, idx + 1, board, word, dir);
    }
    board[i][j] = temp;
    return ex;
  }

  /*** Method 2 ***///Pick, not Pick
  private boolean exist1(
    int i,
    int j,
    int idx,
    char[][] board,
    String word,
    int[][] dir
  ) {
    if (idx == word.length()) {
      return true;
    }

    if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
      return false;
    }

    if (board[i][j] != word.charAt(idx)) {
      return false;
    }

    char temp = board[i][j];
    board[i][j] = '#';

    boolean ex =
      exist(i - 1, j, idx + 1, board, word, dir) ||
      exist(i, j + 1, idx + 1, board, word, dir) ||
      exist(i + 1, j, idx + 1, board, word, dir) ||
      exist(i, j - 1, idx + 1, board, word, dir);

    board[i][j] = temp;
    return ex;
  }
}
