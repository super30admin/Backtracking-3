package com.ds.rani.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */

//Approach: solved using backtracking,consider one row at a time,and traverse over all the columns to check whether it is safe to place the queen in a particular row or not,
// it is considered to place  a queen  safely in row r ,and column c when there is now queen placed on th column c on all the previous rows
// as wll as there is no queen placed on all top left diagonals and top right diagonals

//Time complexity: o(n!)
//Space complexity:o(n) on recursive stack, not considering output space

public class NQueens {
    int[][] chessBoard;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        //create chessboard
        chessBoard = new int[n][n];

        result = new ArrayList();
        //critearia to place the queen is there should be only one queen in one row,one column,and only one queen in every diagonal
        //place one queen in 0 th row
        placeQueen( 0, n );
        return result;
    }

    //check whether it is safe to place queen in given cell(row,col)
    boolean isSafe(int row, int col, int n) {

        //check all the above rows for the same column, if it contains queen already then its not safe to place

        for (int r = 0; r < row; r++) {
            if (chessBoard[r][col] == 1)
                return false;
        }

        //check all left diagonals above the current cell
        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (chessBoard[r][c] == 1)
                return false;
            r--;
            c--;
        }

        //check all right diagonals above the current cell
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (chessBoard[r][c] == 1)
                return false;
            r--;
            c++;
        }
        return true;

    }

    //place queen in row number row
    void placeQueen(int row, int n) {
        //base case
        if (row == n) {
            //once all the queens are placed correctly then convert that in list of strings, one row becomes one string
            List<String> validPlacedQ = new ArrayList<String>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (chessBoard[r][c] == 1)
                        sb.append( "Q" );
                    else
                        sb.append( "." );
                }
                validPlacedQ.add( sb.toString() );
            }
            result.add( validPlacedQ );
            return;

        }


        for (int col = 0; col < n; col++) {
            if (isSafe( row, col, n )) {

                //action for the current row
                chessBoard[row][col] = 1;
                //recurse
                placeQueen( row + 1, n );

                //backtrack
                chessBoard[row][col] = 0;
            }

        }


    }
}
