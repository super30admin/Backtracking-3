// Time Complexity : O(n^2) where n is the number of queens. We are trying to place n queens on an n x n board, and for each queen, we are checking the validity of its position which takes O(n) time.
// Space Complexity : O(n^2) for the board and O(n) for the recursion stack. The board is represented as a 2D boolean array of size n x n, and the recursion stack can go up to n levels deep in the worst case.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// The approach is to use backtracking to place queens on the board.
//  We start from the first row and try to place a queen in each column of that row. 
// For each placement, we check if it is valid (i.e., no other queens can attack it).
//  If it is valid, we place the queen and move to the next row.
//  If we reach the last row and successfully place all queens, we add the current board configuration to the result list.
//  If we cannot place a queen in any column of a row, we backtrack by removing the last placed queen and trying the next column.
//  This process continues until all possible configurations are explored.
import java.util.*;

class Solution {

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {

        result = new ArrayList<>();

        boolean[][] board = new boolean[n][n];

        helper(board, 0, n);

        return result;
    }


    private void helper(boolean[][] board, int row, int n) {

        if (row == n) {

            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {

                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }

                list.add(sb.toString());
            }

            result.add(list);

            return;
        }


        for (int col = 0; col < n; col++) {

            if (isValid(board, row, col, n)) {

                board[row][col] = true;

                helper(board, row + 1, n);

                // backtrack
                board[row][col] = false;
            }
        }
    }


    private boolean isValid(boolean[][] board, int row, int col, int n) {

        // Check same column
        int r = row;

        while (r >= 0) {

            if (board[r][col]) {
                return false;
            }

            r--;
        }


        // Check upper-left diagonal
        r = row;
        int c = col;

        while (r >= 0 && c >= 0) {

            if (board[r][c]) {
                return false;
            }

            r--;
            c--;
        }


        // Check upper-right diagonal
        r = row;
        c = col;

        while (r >= 0 && c < n) {

            if (board[r][c]) {
                return false;
            }

            r--;
            c++;
        }


        return true;
    }
}