// TC : O(n!)
// SC : O(n^2)

package S30_Codes.Backtracking_3;

import java.util.*;

class N_Queens {
    char[][] board;
    List<List<String>> result;
    private char QUEEN = 'Q', EMPTY = '.';
    Set<Integer> columnSet, upperLeftDiagonalSet, upperRightDiagonalSet;

    public List<List<String>> solveNQueens(int n) {
        result= new ArrayList<>();
        board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, EMPTY);
        }

        columnSet = new HashSet<>();
        upperLeftDiagonalSet = new HashSet<>();
        upperRightDiagonalSet = new HashSet<>();

        solveNQueen(0);
        return result;
    }

    private void solveNQueen(int row){
        if(row == board.length){
            List<String> boardList = new ArrayList<>();
            for(char[] boardRow : board){
                boardList.add(new String(boardRow));
            }
            result.add(boardList);
            return;
        }

        for(int col=0; col<board.length; col++){
            if(isSafe(row, col)){
                columnSet.add(col);
                upperLeftDiagonalSet.add(row-col);
                upperRightDiagonalSet.add(row+col);
                board[row][col] = QUEEN;
                solveNQueen(row+1);
                board[row][col] = EMPTY;
                columnSet.remove(col);
                upperLeftDiagonalSet.remove(row-col);
                upperRightDiagonalSet.remove(row+col);
            }
        }
    }

    private boolean isSafe(int row, int col){
        return !columnSet.contains(col) &&
                !upperLeftDiagonalSet.contains(row-col) &&
                !upperRightDiagonalSet.contains(row+col);
    }

}