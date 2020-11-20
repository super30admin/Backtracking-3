package S30.BackTracking_3;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity : O(N!) -
//1st row - N decisions
//2nd row - N-2 places where queen can be placed
//3rd row - N-4 places where queen can be placed
//.... so on
//Number of decisions reducing at each row, and tends to N!, hence the time complexity is O(N!)
Space Complexity : O(NxN) - space taken up by the board
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class NQueens_1 {

    int N;
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        this.result = new ArrayList<>();
        this.board = new int[n][n];
        backtrack(0);
        return result;
    }

    private void backtrack(int row){

        //base
        if(row == N){
            captureStateOfBoard();
            return;
        }

        //logic
        for(int i = 0; i < N; i++){

            if(isQueenSafe(row,i)){
                board[row][i] = 1;
                backtrack(row+1);
                board[row][i] = 0; // mark 0, whether it works out or not
            }
        }

    }

    private boolean isQueenSafe(int row, int col){

        //column up
        for(int i = 0; i < row; i++){
            if(board[i][col] == 1) return false;

        }

        //diagonal left
        int i = row; int j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;j--;
        }

        //diagonal right
        i = row; j = col;
        while(i >= 0 && j < N){
            if(board[i][j] == 1) return false;
            i--;j++;
        }

        //queen is safe
        return true;

    }

    private void captureStateOfBoard(){

        List<String> temp = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++){
                if(board[i][j] == 1) sb.append("Q");
                else sb.append(".");
            }
            temp.add(sb.toString());

        }

        result.add(temp);
    }
}
