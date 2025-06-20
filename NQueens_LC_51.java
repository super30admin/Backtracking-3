/*
Time Complexity	= O(N × N!)
Space Complexity	O(N² + N + kN) where k = number of valid solutions
*/
public class NQueens_LC_51 {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        boolean[][] board = new boolean [n][n];
        backtrack(board, 0, result);
        return result;
    }
    private void backtrack(boolean[][] board, int row, List<List<String>> result){
        //base case
        //if row is at board lenght start processing the board
        if(row == board.length){
            List<String> queenList = new ArrayList<>();
            for(int i = 0; i< board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<board.length; j++){
                    if(board[i][j]) { //Queen Found add it strinbuilder
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                queenList.add(sb.toString());
            }
            result.add(queenList);
            return;
        }


        //logic
        for(int col = 0 ; col< board.length; col++){
            if(isSafe(board, row, col)){
                //action
                board[row][col] =true;
                //recurse
                backtrack(board, row+1, result);
                //backtrack from here
                board[row][col] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        //check Up columns to place the queen
        for(int i = 0 ; i< row; i++){
            if(board[i][col]){
                return false;
            }
        }
        //up left diagonal
        int curRow = row;
        int curCol = col;
        while(curRow >= 0 && curCol >= 0){
            if(board[curRow][curCol]){
                return false;
            }
            curRow--;
            curCol--;
        }
        //up right diagonal
        int curRow1 = row; int curCol1 = col;
        while(curRow1 >= 0 && curCol1 < board.length){
            if(board[curRow1][curCol1]){
                return false;
            }
            curRow1--;
            curCol1++;
        }
        return true;
    }

}