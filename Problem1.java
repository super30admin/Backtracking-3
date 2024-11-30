// Time Complexity :O(n!)
// Space Complexity :O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    List<List<String>> res;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board= new boolean[n+1][n+1];
        helper(0, n);
        return res;
    }

    private void helper(int row, int n){
        if(row==n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        }


        for(int j=0; j<n; j++){
            if(isSafe(board,row,j,n)){
                board[row][j]=true;
                helper(row+1,n);
                board[row][j]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int i, int j, int n){
        int r=i; int c=j;
        while(r>=0){
            if(board[r][c]) return false;
            r--;
        }

        r=i; c=j;
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--; c--;
        }

        r=i; c=j;
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--; c++;
        }
        return true;
    }
}
