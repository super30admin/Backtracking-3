//Approach - Backtracking
//Time Complexity - O(n!)
//Space Complexity - O(n)

class Solution {
  List<List<String>> result;
  int[][] board;
  int m;
  public List<List<String>> solveNQueens(int n) {

    result = new ArrayList<>();

    if(n == 0){
      return result;
    }
    board = new int[n][n];
    m=n;
    backtrack(0);
    return result;
  }

  public void backtrack(int n){

    if(n == m){
      List<String> path = new ArrayList<>();

      for(int i=0; i<m; i++){
        StringBuilder sb = new StringBuilder();
        //
        for(int j=0; j<m; j++){

          if(board[i][j] == 1){
            sb.append("Q");
          }
          else{
            sb.append(".");
          }
        }
        path.add(sb.toString());
      }
      result.add(path);
      return;
    }

    for(int i=0; i<m; i++){
      if(isSafe(n,i)){
        board[n][i] = 1;
        backtrack(n+1);
        board[n][i] = 0;
      }
    }
  }


  public boolean isSafe(int r, int c){
    for(int i=0; i<r; i++){
      if(board[i][c] == 1){
        return false;
      }
    }

    int x=r-1, y=c-1;

    while(x>=0 && y >=0){
      if(board[x][y] == 1){
        return false;
      }
      x--;
      y--;
    }

    x=r-1;
    y=c+1;

    while(x>=0 && y <m){
      if(board[x][y] == 1){
        return false;
      }
      x--;
      y++;
    }

    return true;
  }
}
