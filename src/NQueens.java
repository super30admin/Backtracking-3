// Time Complexity:           O(n! + (n^2 * s))
// Space Complexity:          O(4n + n^2 = n^2)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public static void main(String[] args) {
        SolutionNQueens obj = new SolutionNQueens();
        int n = 4;
        List<List<String>> list = obj.solveNQueens(n);
        System.out.println(list);
    }
}

class SolutionNQueens {

    List<List<String>> list;
    boolean[][] board;
    Set<Integer> colSet, upperLeftSet, upperRightSet;

    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        board = new boolean[n][n];
        colSet = new HashSet<>();
        upperLeftSet = new HashSet<>();
        upperRightSet = new HashSet<>();

        solveNQueens(board, 0);

        return list;
    }

    private void solveNQueens(boolean[][] board, int row) {

        // BASE
        if(row == board.length) {
            List<String> temp = new ArrayList<>();

            for(int i=0; i<board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            list.add(temp);
            return;
        }


        // RECURSE
        for(int col = 0; col<board[0].length; col++) {

            // ACTION
            if(isSafePosition(row, col)) {
                board[row][col] = true;
                colSet.add(col);
                upperLeftSet.add(row-col);
                upperRightSet.add(row+col);

                solveNQueens(board, row+1);

                // BACTRACKING
                board[row][col] = false;
                colSet.remove(col);
                upperLeftSet.remove(row-col);
                upperRightSet.remove(row+col);
            }
        }
    }


    // Check if position is safe or not
    private boolean isSafePosition(int row, int col) {
        return
                isSafeCol(row, col)
                        && isSafeUpperLeft(row, col)
                        && isSafeUpperRight(row, col);
    }

    // check if any of the upper rows with same column has queen or not
    private boolean isSafeCol(int row, int col) {
        return !colSet.contains(col);
    }

    // check if any of the upper rows with left diagonal column has queen or not
    private boolean isSafeUpperLeft(int row, int col) {
        return !upperLeftSet.contains(row-col);
    }

    // check if any of the upper rows with right diagonal column has queen or not
    private boolean isSafeUpperRight(int row, int col) {
        return !upperRightSet.contains(row+col);
    }
}





//// ****************************** Another Approach ******************************
//// Time Complexity: O(n!)
//// Space Complexity: O(n + n^2 = n^2)
//
//class SolutionNQueens {
//
//    List<List<String>> list;
//    boolean[][] board;
//
//    public List<List<String>> solveNQueens(int n) {
//        list = new ArrayList<>();
//        board = new boolean[n][n];
//
//        solveNQueens(board, 0);
//
//        return list;
//    }
//
//    private void solveNQueens(boolean[][] board, int row) {
//
//        // BASE
//        if(row == board.length) {
//            List<String> temp = new ArrayList<>();
//
//            for(int i=0; i<board.length; i++) {
//                StringBuilder sb = new StringBuilder();
//                for(int j=0; j<board[0].length; j++) {
//                    if(board[i][j]) {
//                        sb.append('Q');
//                    }
//                    else {
//                        sb.append('.');
//                    }
//                }
//                temp.add(sb.toString());
//            }
//            list.add(temp);
//            return;
//        }
//
//
//        // RECURSE
//        for(int col = 0; col<board[0].length; col++) {
//
//            // ACTION
//            if(isSafePosition(row, col)) {
//                board[row][col] = true;
//                solveNQueens(board, row+1);
//
//                // BACKTRACKING
//                board[row][col] = false;
//            }
//        }
//    }
//
//
//    // Check if position is safe or not
//    private boolean isSafePosition(int row, int col) {
//        return
//                isSafeCol(row, col)
//                        && isSafeUpperLeft(row, col)
//                        && isSafeUpperRight(row, col);
//    }
//
//    // check if any of the upper rows with same column has queen or not
//    private boolean isSafeCol(int row, int col) {
//        int i = row-1;
//        int j = col;
//        while(i >= 0) {
//            if(board[i][j])
//                return false;
//            i--;
//        }
//        return true;
//    }
//
//    // check if any of the upper rows with left diagonal column has queen or not
//    private boolean isSafeUpperLeft(int row, int col) {
//        int i = row - 1;
//        int j = col - 1;
//        while(i >= 0 && j >= 0) {
//            if(board[i][j])
//                return false;
//            i--;
//            j--;
//        }
//        return true;
//    }
//
//    // check if any of the upper rows with right diagonal column has queen or not
//    private boolean isSafeUpperRight(int row, int col) {
//        int i = row - 1;
//        int j = col + 1;
//        while(i >= 0 && j < board[0].length) {
//            if(board[i][j])
//                return false;
//            i--;
//            j++;
//        }
//        return true;
//    }
//}
//
//
//
//
//
//
//// ****************************** Another Approach ******************************
//// Time Complexity: O(n!)
//// Space Complexity: O(n + n^2 = n^2)
//
//class SolutionNQueens {
//
//    List<List<String>> list;
//    boolean[][] board;
//
//    public List<List<String>> solveNQueens(int n) {
//        list = new ArrayList<>();
//        board = new boolean[n][n];
//
//        solveNQueens(board, 0);
//
//        return list;
//    }
//
//    private void solveNQueens(boolean[][] board, int col) {
//
//        // BASE
//        if(col == board[0].length) {
//            List<String> temp = new ArrayList<>();
//
//            for(int i=0; i<board.length; i++) {
//                StringBuilder sb = new StringBuilder();
//                for(int j=0; j<board[0].length; j++) {
//                    if(board[i][j]) {
//                        sb.append('Q');
//                    }
//                    else {
//                        sb.append('.');
//                    }
//                }
//                temp.add(sb.toString());
//            }
//            list.add(temp);
//            return;
//        }
//
//
//        // RECURSE
//        for(int row = 0; row<board.length; row++) {
//
//            // ACTION
//            if(isSafePosition(row, col)) {
//                board[row][col] = true;
//                solveNQueens(board, col+1);
//
//                //BACKTRACKING
//                board[row][col] = false;
//            }
//        }
//    }
//
//
//    // Check if position is safe or not
//    private boolean isSafePosition(int row, int col) {
//        return
//                isSafeRow(row, col)
//                        && isSafeUpperLeft(row, col)
//                        && isSafeLowerLeft(row, col);
//    }
//
//    // check if any of the left columns with same row has queen or not
//    private boolean isSafeRow(int row, int col) {
//        int i = row;
//        int j = col-1;
//        while(j >= 0) {
//            if(board[i][j])
//                return false;
//            j--;
//        }
//        return true;
//    }
//
//    // check if any of the upper rows with left diagonal column has queen or not
//    private boolean isSafeUpperLeft(int row, int col) {
//        int i = row - 1;
//        int j = col - 1;
//        while(i >= 0 && j >= 0) {
//            if(board[i][j])
//                return false;
//            i--;
//            j--;
//        }
//        return true;
//    }
//
//    // check if any of the lower rows with left diagonal column has queen or not
//    private boolean isSafeLowerLeft(int row, int col) {
//        int i = row + 1;
//        int j = col - 1;
//        while(i < board.length && j >= 0) {
//            if(board[i][j])
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//}
