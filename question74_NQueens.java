package Backtracking3;

import java.util.ArrayList;
import java.util.List;

public class question74_NQueens {
    /* Created by palak on 7/6/2021 */

    /*
        Time Complexity: O(n!)
        Space Complexity: O(n ^ 2)
    */

    boolean[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 2 || n == 3) return result;
        board = new boolean[n][n];
        backtrack(0, n);
        return result;
    }
    private void backtrack(int r, int n) {
        //Base
        if(r == n) {
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < n ; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        //Logic
        for(int j = 0 ; j < n ; j++) {
            //if the queen is safe to be put at that cell. We cant out the queen at any cell, we must check if it is safe or not.
            if(isSafe(r, j, n)) {
                //action i.e. put the queen here
                board[r][j] = true;
                //Recurse
                backtrack(r + 1, n);
                //Backtrack
                board[r][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n) {
        //Column up
        for(int i = 0 ; i < r ; i++) {
            if(board[i][c]) return false;
        }

        //Diagonal up left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) return false;
            i--;
            j--;
        }

        i = r;
        j = c;
        //Diagonal up right
        while(i >= 0 && j < n) {
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
