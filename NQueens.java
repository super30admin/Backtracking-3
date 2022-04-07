class NQueens {
  /**
   * Time Complexity: O(n * n!)
   *      n! -> at first level we have n columns to pick from ,(n-2) next , approx (n-4) next and so on
   *      n -> on each pick, `isSafe` operation takes O(n) time.
   * 
   * Space Complexity: O(n^2) - > for board and O(n) -> recursive stack
   * 
   * Were you able to solve this on leetcode? Yes
   */

  boolean[][] board;
  List<List<String>> result;
  int size;
  public List<List<String>> solveNQueens(int n) {
      
      board = new boolean[n][n];
      result = new ArrayList<>();
      
      size = n;
      placeQueens(0);
      return result;
  }
  
  void placeQueens(int row){
      // base cases
      if(row == size) { // means that we have successfully placed Queen on all rows.
          // save the board to result;
          List<String> curr_board = new ArrayList<>();
          for(int i = 0; i < size; i++) {
              StringBuilder sb = new StringBuilder();
              
              for (int j = 0; j < size; j++){
                  if(board[i][j] == true){
                      sb.append('Q');
                  } else{
                      sb.append('.');
                  }
              }
              curr_board.add(sb.toString());
          }
          result.add(curr_board);
          return;
      }
      
      // logic
      // iterate over each column in the row and place queen at a safe spot
      for(int i = 0; i < size; i++){
          // if it is safe to place queen, place it
          if(isSafe(row, i)){ // we are only performing action and going to the next level when we could place a queen in the current level
              // action
              board[row][i] = true;
          
              // recurse
              placeQueens(row + 1);
              
              // backtrack
              board[row][i] = false;   
          }
      }
  }
  
  boolean isSafe(int row, int col){
      // since we are filling the board from top to bottom, we only have to check the top portion of the current row
      // vertical check
      for(int i = 0; i <= row; i++){
          if(board[i][col] == true){
              return false;
          }
      }
      
      // horizontal check - is this required?
      for(int j = 0; j < size; j++){
          if(board[row][j] == true){
              return false;
          }
      }
      
      // diagonal left check
      int curr_row = row;
      int curr_col = col;
      while(curr_row >=0 && curr_col >= 0){
          if(board[curr_row][curr_col] == true){
              return false;
          }
          curr_row--;
          curr_col--;
      }
      
      // diagonal right check
      curr_row = row;
      curr_col = col;
       while(curr_row >=0 && curr_col < size){
           if(board[curr_row][curr_col] == true){
              return false;
          }
          curr_row--;
          curr_col++;
       }
      
      return true;
  }
}