public class WordSearch {
  /**
   * Time Complexity: O(m*n  * 3 ^ L)
   *     m * n -> for iterating over the matrix
   *     L -> lenght of word. At each character in word, we have 3 possible paths, so 3^L
   * 
   * 
   * Space Complexity: O(L)
   *   recursive stack takes goes L deep
   * 
   * Were you able to solve this on leetcode? Yes
   */

  int[][] dirs;
    
  public boolean exist(char[][] board, String word) {
      
      int m = board.length;
      int n = board[0].length;
      boolean[][] visited = new boolean[m][n];
      dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n ; j++){
              if(word.charAt(0) == board[i][j]){
                  boolean res = backtrack(board, visited, word, i , j, 0);
                  if(res) { return true; }
              }
          }
      }
      return false;
  }
  
  boolean backtrack(char[][] board, boolean[][] visited, String word, int row, int col, int idx){
      // base case
       if(idx == word.length()) { return true; }
      if(row < 0 || col < 0 || row == board.length || col == board[0].length){ return false; }
     
      if(board[row][col] != word.charAt(idx) || visited[row][col]) { return false; }
      
      
      
      // logic
      // mark the current index visited
      visited[row][col] = true;
      
      // recurse
      for(int[] dir : dirs){
          int nr = row + dir[0];
          int nc = col + dir[1];
          
          if(backtrack(board, visited, word, nr, nc, idx+1)){
              return true;
          }
      }
      
      // backtrack
      visited[row][col] = false;
      
      return false;
  }
}
