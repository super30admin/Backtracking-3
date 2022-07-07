// Time Complexity : O(n!) where n is the no:of rows in chessboard
// Space Complexity : O(n^2) where n is the no:of rows in chessboard
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could think of the logic but couldn't code it.


import java.util.*;

class Nqueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0) return result;
        boolean [][] board = new boolean[n][n];
        backtrack(board, 0);
        return result;
    }

    private void backtrack(boolean [][] board, int r){
        //base
        if(r==board.length){
            List<String> li = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for(int i=0;i<board.length;i++){
            if(isSafe(board, r, i)){
                //action
                board[r][i]=true;
                //recurse
                backtrack(board, r+1);
                //backtrack
                board[r][i]=false;
            }
        }
    }

    private boolean isSafe(boolean [][] board, int r, int c){
        //up col
        for(int i=0;i<r;i++){
            if(board[i][c]) return false;
        }
        //diag up left
        int i=r; int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        i=r; j=c;
        while(i>=0 && j<board.length){
            if(board[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }

    public static void main(String [] args){
        Nqueens nq = new Nqueens();
        System.out.println(nq.solveNQueens(4));
    }
}