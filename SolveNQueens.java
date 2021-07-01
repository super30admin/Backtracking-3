import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n!)  exponential
 * // Space Complexity : O(n*n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    int[][] board; int m;
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return res;
        m=n;
        board = new int[m][m];
        backtrack(0);
        return res;
    }
    private void backtrack(int row){
        //base
        if(row==m){
            List<String> li=new ArrayList<>();
            for(int i=0; i<m; i++){
                StringBuilder sb =new StringBuilder();
                for(int j=0; j<m; j++){
                    if(board[i][j]==1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        //logic
        for(int i=0; i<m; i++){
            if(isSafe(row, i)){
                board[row][i]=1;
                backtrack(row+1);
                board[row][i]=0;
            }
        }
    }
    private boolean isSafe(int r, int c){
        //colump up
        for(int i=r; i>=0; i--){
            if(board[i][c]==1)
                return false;
        }
        // diagonal left
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1)
                return false;
            i--; j--;
        }
        //diagonal right
        i=r; j=c;
        while(i>=0 && j<m){
            if(board[i][j]==1)
                return false;
            i--; j++;
        }
        return true;
    }
}