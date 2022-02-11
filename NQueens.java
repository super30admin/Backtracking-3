// Time Complexity : Add : O(N * N!), 
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        solveNQueens(4);
    }

    static List<List<String>> result;
    static int N;
    static boolean[][] board;
    public static List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        N=n;
        board = new boolean[n][n];

        helper(0);

        return result;
    }

    private static void helper(int i){  //T.C - O(N * N!)  S.C - O(1)
        //base
        if(i == N){
            List<String> li = new ArrayList<>();
            for(int k=0; k<N; k++){
                StringBuilder sb = new StringBuilder();
                for(int l=0; l<N; l++){
                    if(board[k][l])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for(int j=0; j<N; j++){
            if(isSafe(i, j)){
                //action
                board[i][j] = true;
                //recursion
                helper(i+1);
                //backtrack
                board[i][j] = false;
            }
        }
    }

    private static boolean isSafe(int r, int c){
        // if queen is found in the same column, return false
        for(int i=0; i<=r; i++){
            if(board[i][c])
                return false;
        }

        // if queen is found in the diagonal left, return false
        int a = r;
        int b = c;
        while(a>=0 && b>=0){
            if(board[a][b])
                return false;
            a--;
            b--;
        }

        // if queen is found in the diagonal right, return false
        a = r;
        b = c;
        while(a>=0 && b<N){
            if(board[a][b])
                return false;
            a--;
            b++;
        }
        return true;
    }
}

