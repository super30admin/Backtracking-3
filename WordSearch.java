//Approach - Backtracking
//Time Complexity - worst case - M.N. 3^L
//           where M and N are length & bread of board, L - length of the word
//Space Complexity - O(L) - recursion call stack where L - length of the word

class Solution {
  int m, n;
  public boolean exist(char[][] board, String word) {

    if(board == null || board.length == 0){
      return false;
    }

    m = board.length;
    n = board[0].length;

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){

        if(board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)){
          return true;
        }
      }
    }
    return false;
  }

  public boolean backtrack(char[][] board, String word, int i, int j, int index){

    if(index == word.length()){
      return true;
    }

    if(i < 0 || i>= m || j < 0 || j>= n || board[i][j] != word.charAt(index)){
      return false;
    }

    char temp = board[i][j];
    board[i][j] = '#';

    boolean result = backtrack(board, word, i+1, j, index+1) || backtrack(board, word, i-1, j, index+1) || backtrack(board, word, i, j+1, index+1) || backtrack(board, word, i, j-1, index+1);

    board[i][j] = temp;
    return result;
  }

}
