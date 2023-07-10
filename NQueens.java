// Time Complexity : O(n!) where n is the number of queens
// Space Complexity :O(n*n) where n is the number of queens
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];

        helper(n, board, 0);

        return result;
    }

    private void helper(int n, boolean[][] board, int r){
        //base
        if(r == board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i< board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j =0; j< board[0].length; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for(int i = 0; i <n; i++){
            //action
            if(isSafe(board, r, i)){
                board[r][i] = true;
                //recurse
                helper(n, board, r+1);
                //backtrack
                board[r][i] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r,  int c){
        //column up
        for(int i =0; i< r; i++){
            if(board[i][c]) return false;
        }
        //diagonal left up
        int i = r;
        int j = c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--; j--;
        }
        //diagonal right up
        i = r;
        j = c;
        while(i>=0 && j<board[0].length){
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }
}
