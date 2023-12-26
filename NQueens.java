// Time complexity : O(n!)
// Space complexity : O(n^2)

import java.util.*;
class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }

    static List<List<String>> result;
    private static List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board,0);
        return result;
    }

    private static void backtrack(boolean[][] board, int i) {
        // base
        if(i == board.length) {
            List<String> li = new ArrayList<>();
            for(int r=0;r<board.length;r++) {
                StringBuilder sb = new StringBuilder();
                for(int c=0;c<board[0].length;c++) {
                    if(board[r][c]) sb.append("Q");
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // logic
        for(int j=0;j<board[0].length;j++) {
            if(isSafe(board, i , j)) {
                // action
                board[i][j] = true;
                // recurs
                backtrack(board,i+1);
                // backtrack
                board[i][j] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        // column up
        for(int i=0;i<r;i++) {
            if(board[i][c]) return false;
        }
        // diagonal up left
        int i = r;
        int j = c;
        while(i >=0 && j >=0) {
            if(board[i][j]) return false;
            i--;
            j--;
        }
        i = r;
        j = c;
        while(i >=0 && j < board[0].length) {
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}