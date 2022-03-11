import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(N!+ valid solutions*N^2), here N is the number of places where I can keep my first queen
Space Complexity: O(N^2), N is the row and col of board boolean matrix

Approach:
Attempted after discussed in the class
 */
public class NQueens {
    private static List<List<String>> result;
    private static boolean[][] board;
    public static List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        result = new ArrayList<>();

        solveNQueens(board, 0);
        return result;
    }

    public static void solveNQueens(boolean[][] board, int row){

        // base condition

        if(row == board.length){
            List<String> queens = new ArrayList<>();
            for(int i = 0; i<board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<board.length; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                queens.add(sb.toString());
            }
            result.add(queens);
            return;
        }

        // recurse+action+backtrack

        for(int col = 0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true; // action of placing queen
                solveNQueens(board, row+1); // recurse
                board[row][col] = false; // backtracking
            }
        }
    }

    public static boolean isSafe(boolean[][]board, int row, int col){
        return isSafeCol(board, row, col) && isSafeDia(board, row, col) && isSafeAntiDia(board, row, col);
    }
    /*
    Now I am checking every column if I can place my other queen there or not, to do so, I just need to check upper
    row's column as I am starting for the zeroth row
     */
    public static boolean isSafeCol(boolean[][]board, int row, int col){
        for(int i = row; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        return true;
    }
    /*
     Now I am checking in the left upper column (Diagonal) if I can place my other queen there or not, to do so,
     I just need to check upper row's column as I am starting for the zeroth row so my leftUpperColumn indexes gonna
     be row-1, and col-1
     */
    public static boolean isSafeDia(boolean[][]board, int row, int col){
        int i = row-1;
        int j = col-1;

        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
    /*
     Now I am checking in the right upper column (Anti-Diagonal) if I can place my other queen there or not, to do so,
     I just need to check upper row's column as I am starting for the zeroth row so my rightUpperColumn indexes gonna
     be row-1, and col+1
     */
    public static boolean isSafeAntiDia(boolean[][]board, int row, int col){
        int i = row-1;
        int j = col+1;

        while(i>=0 && j<board.length){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(solveNQueens(4));
    }
}
