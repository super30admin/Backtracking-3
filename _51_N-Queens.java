// Time Complexity : o(n!))
// Space Complexity : o(n*n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// For every row place a queen and call recusion for next queen from next row starting if not possible backtrack

class Solution {

    Set<Integer> row;
    Set<Integer> column;
    Set<Integer> diagonalright;
    Set<Integer> diagonalleft;

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        row = new HashSet<>();
        column = new HashSet<>();
        diagonalright = new HashSet<>();
        diagonalleft = new HashSet<>();

        res = new ArrayList<>();

       char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        dfs(n, 0, 0, 0, board);
        return res;

    }

    public void dfs(int n, int count, int x, int y, char[][] board) {

        if(n == count){
            copyBoard(board);
            return;
        }
        int i = count;
        //if we use for loop fist queen will be tried to b placed in all cells one by one but we dont need to place 1st queen except row 1
        //same for other queens too
        //for(int i=x; i<n; i++){
              for(int j=y; j<n; j++){

                  if(isValidPlacement(i,j)){

                      row.add(i);
                      column.add(j);
                      diagonalright.add(i-j);
                      diagonalleft.add(i+j);

                      board[i][j] = 'Q';

                      dfs(n, count+1, i+1, 0, board);

                      board[i][j] = '.';

                      row.remove(i);
                      column.remove(j);
                      diagonalright.remove(i-j);
                      diagonalleft.remove(i+j);

                  }

              }
        //}

    }

    public boolean isValidPlacement(int i, int j){
        if( row.contains(i)   ||
            column.contains(j) ||
            diagonalright.contains(i-j)  ||
            diagonalleft.contains(i+j)  ){
                return false;
        }
        return true;
    }


    public void copyBoard(char[][] board){
        List<String> boardList = new ArrayList<>();
        for(char[] row : board){
            boardList.add(new String(row));
        }
        res.add(boardList);
    }


    public int getCellId(int n, int i, int j){
        return (i%n)*n + j%n;
    }


}
