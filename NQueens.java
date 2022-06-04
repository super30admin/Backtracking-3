
// Time Complexity : O(e^(n))
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private List<List<String>> result;
    private int m;
    private boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new boolean[m][m];
        helper(0);
        return result;
    }
    private void helper(int row){
        //basic 
        if(row == m){
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i < m; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j]) stringBuilder.append("Q");
                    else stringBuilder.append(".");
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return;
        }
        
        //logic
        for(int i = 0; i < m; i++){
            if(isSafe(i, row)){
                board[row][i] = true;
                helper(row+1);
                board[row][i] = false;
            }
        }
    }
    private boolean isSafe(int column, int row){
        for(int i = 0; i < row; i++){
            if(board[i][column]) return false;
        }
        int r = row;
        int c = column;
        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--;
            c--;
        }
        r = row;
        c = column;
        while(r >= 0 && c < m){
            if(board[r][c]) return false;
            r--;
            c++;
        }
        return true;
    }
    
}