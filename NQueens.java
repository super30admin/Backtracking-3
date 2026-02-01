/*
Time Complexity : O(N!. 3N) where N is the size of the board. 3N for validating the placement at each cell
Space Complexity : O(N) on the recursion stack
Did this code successfully run on Leetcode :
Any problem you faced while coding this :
Approach :

We need to place N queens on the board. Need to check if the placement is valid. If yes, add the placement string to
result list. We can create a NXN boolean board, where true represent a queen is placed and false represents otherwise.
 We can place one queen row by row, so for a row, we place the queen from 0 to jth column. Once the queen is placed
 successfully, we call the recursion on the next row. Once all rows are done, we need to convert the board into list
of strings and add to result.

Before placing a queen, we check its column, its top right and top left diagonals, if a queen is already placed there,
we return false.

Finally, if all queens are placed correctly, we create a string with Q and . from true and false state of the board.

*/
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // Create board to keep the state
        boolean[][] board = new boolean[n][n];
        placeQueens(board, 0, result);
        return result;
    }

    private void placeQueens(boolean[][] board,int i, List<List<String>> result) {
        int rows = board.length;
        // If we reach the row size, we have a valid solution and add it to result
        if(i == rows){
            List<String> solution = convertBoardToString(board);
            result.add(solution);
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if(isValidPlacement(board, i, j)){
                board[i][j] = true;
                placeQueens(board, i+1, result);
                // backtrack
                board[i][j] = false;
            }

        }

    }

    boolean isValidPlacement(boolean[][] board, int i, int j){
        int tempi = i;
        int tempj = j;
        // check top left diagonal
        while(tempi >= 0 && tempj >= 0){
            if(board[tempi][tempj]) return false;
            tempi--;
            tempj--;
        }
        tempi = i;
        tempj = j;

        // check all values in the same column
        while(tempi >= 0){
            if(board[tempi][tempj]) return false;
            tempi--;
        }

        tempi = i;
        tempj = j;
        // check for queen in the top right diagonal
        while(tempi >= 0 && tempj < board[0].length){
            if(board[tempi][tempj]) return false;
            tempi--;
            tempj++;
        }

        return true;
    }

    private List<String> convertBoardToString(boolean[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                // convert board state to list of strings
                if(board[i][j]){
                    temp.append("Q");
                }else {
                    temp.append(".");
                }
            }
            solution.add(temp.toString());
        }
        return solution;
    }
}
