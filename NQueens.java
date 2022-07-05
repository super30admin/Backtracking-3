// Time Complexity : n factorial —- (n * n!) - first n - isSafe(), n! - for exploring options
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> result;
    int N;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        result = new ArrayList<>();
        N = n;
        backtrack(0);
        return result;
    }

    private void backtrack(int i){
        //base
        if(i == N){
            List<String> sol = new ArrayList<>();
            for(int k =0 ; k < N; k++){
                StringBuilder sb = new StringBuilder();
                for(int j =0 ; j < N; j++){
                    if(board[k][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                sol.add(sb.toString());
            }
            result.add(sol);
        }

        //logic
        //check for columns
        for(int j =0 ; j < N; j++){
            if(isSafe(i,j)){
                //action
                board[i][j] = true;
                //recurse
                backtrack(i+1);
                //backtrack
                board[i][j] = false;
            }
        }

    }

    private boolean isSafe(int r, int c){

        //For every row till r, check column up
        for(int i = 0; i <= r; i++){
            if(board[i][c]) return false;
        }

        //check diagonal up left
        int i = r, j = c;
        while(i >=0 && j >=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }

        //check diagonal right left
        i = r; j = c;
        while(i >=0 && j < N){
            if(board[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }
}
