package s30.backTracking.b3;

import java.util.*;

//Algo conditional backtracking
// Place queen at valid index and check if it can solve the problem else backtrack
// use colset, topLeftSet and topRightSet to validate the position


//TC: N!, for N*N matrix, at every row we have more than lesser possibilities
//SC: N, At most we'll have row number of recursive function calls.
public class NQueens {
    char[][] board;
    List<List<String>> res;

    Set<Integer> colSet;
    Set<Integer> leftUpSet;
    Set<Integer> rightUpSet;


    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];
        res = new ArrayList();
        colSet = new HashSet();
        leftUpSet = new HashSet();
        rightUpSet = new HashSet();

        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        solveNQueens(n,0);

        return res;
    }

    private void solveNQueens(int n, int i){
        //base
        if(i == n){
            List<String> curr = new ArrayList();
            for(char[] row : board){
                curr.add(new String(row));
            }

            res.add(curr);
        }

        for(int j = 0; j < n; j++){



            if(validIndex(i,j)){
                board[i][j] = 'Q';
                colSet.add(j);
                leftUpSet.add(i-j);
                rightUpSet.add(i + j);

                solveNQueens(n, i+1);

                board[i][j] = '.';
                colSet.remove(j);
                leftUpSet.remove(i-j);
                rightUpSet.remove(i + j);
            }


        }

    }

    private boolean validIndex(int i, int j){

        return isValidCol(j) && isValideLeftUp(i,j) && isValidRightUp(i,j);
    }

    private boolean isValidCol(int col){
        return !colSet.contains(col);
    }

    private boolean isValideLeftUp(int row, int col){
        return !leftUpSet.contains(row - col);
    }

    private boolean isValidRightUp(int row, int col){
        return !rightUpSet.contains(row + col);
    }
    public static void main(String[] args) {

    }
}
