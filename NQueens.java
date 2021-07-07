// Time Complexity : O(n*n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> output;
    public List<List<String>> solveNQueens(int n){
        output = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(board,0, n);
        return output;
    }

    // here, as columns and diagonals are taken care in isSafe, we are checking only rows here.
    private void backtrack(char[][] board, int i, int n){
        if(n == 0){
            // input into result
            insertInput(board);
        }

        for(int j = 0; j < board.length; j++){
            if(isSafe(board, i, j)){
                board[i][j] = 'Q';
                backtrack(board, i+1, n-1);
                board[i][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int i, int j){
        // upwards as downwards is empty
        // check column upwards

        for(int x = 0; x < i; x++){
            if(board[x][j] == 'Q'){
                return false;
            }
        }
        // check left diagonal upwards

        int x = i-1;
        int y = j-1;
        while(x >= 0 && y >= 0){
            if(board[x][y] == 'Q'){
                return false;
            }

            x--;
            y--;
        }
        // check right diagonal upwards

        x = i-1;
        y = j+1;
        while(x >= 0 && y <= board[0].length - 1){
            if(board[x][y] == 'Q'){
                return false;
            }

            x--;
            y++;
        }

        return true;
    }

    private void insertInput(char[][] board){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            String temp = "";
            for(int j = 0; j < board[0].length; j++){
                temp += board[i][j];
            }
            list.add(temp);
        }
        output.add(list);
    }


}
