//Time Complexity: O(N!)
//Space Complexity: O(N^2)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        boolean[] column = new boolean[n];
        boolean[] diagonalUp = new boolean[2*n-1];
        boolean[] diagobalDown = new boolean[2*n-1];
        helper(board, column, diagonalUp , diagobalDown , 0 , result);
        return result;

    }
    public void helper(boolean[][] board, boolean[] column, boolean[] diagonalUp, boolean[] diagonalDown, int row, List<List<String>> result ){
        if(row == board.length){
            List<String> ls = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j] == true){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                ls.add(sb.toString());
            }
            result.add(ls);
            return;
        }
        for(int col=0; col< board[0].length; col++){
            if(column[col] == false && diagonalUp[row+col] == false && diagonalDown[row-col + board.length-1] == false){
                board[row][col] = true;
                column[col] = true;
                diagonalUp[row+col] = true;
                diagonalDown[row-col + board.length-1] = true;
                //Next row
                helper(board, column, diagonalUp , diagonalDown , row + 1,result);
                //backtracking
                board[row][col] = false;
                column[col] = false;
                diagonalUp[row+col] = false;
                diagonalDown[row-col + board.length-1] = false;
            }
        }
    }
}