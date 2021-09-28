package Backtracking3;
// Time Complexity :O(n!*diagonal of matrix(isSafe function))
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    char[][] board;
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(0);
        return result;
    }
    private void addBoard(){
        List<String> temp = new ArrayList<>();
        for(int i=0; i<board.length;i++){
            StringBuilder s = new StringBuilder();
            for(int j=0; j<board.length; j++){
                s.append(board[i][j]);
            }
            temp.add(s.toString());
        }
        result.add(temp);
    }
    private void backtrack(int r){
        //base
        if(r >= board.length){
            addBoard();
            return;
        }
        //logic
        for(int j=0; j<board.length; j++){
            if(isSafe(r-1, j)){
                board[r][j] = 'Q';
                backtrack(r+1);
                board[r][j] = '.';
            }
        }

    }
    private boolean isSafe(int r, int c){
        //col
        for(int i=r; i>=0; i--){
            if(board[i][c] == 'Q')
                return false;
        }
        //left diag
        for(int i=r, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }

        //right diag
        for(int i=r, j=c+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
