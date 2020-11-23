// Time Complexity : O(n!) where n is no.of queens
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We are using backtracking approach to find all the possible solutions.
 * */

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0) return result;
        board = new int[n][n];
        m=n;
        helper(0);
        return result;
    }

    private void helper(int row){
        //base
        if(row==m){
            List<String> temp = new ArrayList<>();
            StringBuilder sb;
            for(int i=0; i<m ; i++){
                sb = new StringBuilder();
                for(int j=0; j<m; j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }

        for(int j=0; j<m; j++){
            if(isSafe(row, j)){
                //action
                board[row][j]=1;
                //recurse
                helper(row+1);
                //backtrack
                board[row][j]=0;
            }
        }
    }

    private boolean isSafe(int r, int c) {
        //all above row with same column
        for(int i=0; i<r; i++){
            if(board[i][c]==1) return false;
        }

        //diagonal up left
        int i=r,j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--; j--;
        }

        //diagonal up right
        i=r;j=c;
        while (i>=0 && j<m){
            if (board[i][j]==1) return false;
            i--; j++;
        }
        return true;
    }
}
