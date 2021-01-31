import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Time Complexity :O(n!)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Getting started

// Your code here along with comments explaining your approach

public class NQueens {

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();

            //create 2d array
            char[][] board = new char[n][n];

            //initialize the board with dots
            init(board);

            //helper function to determine where to place Q
            helper(board, res, 0);
            return res;
        }

        //fill the board with  dots
        private void init(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                Arrays.fill(board[i], '.');
            }
        }

        private void helper(char[][] board, List<List<String>> res, int rowIndex) {
            //when at the end of the board generate list of strings
            //base case
            if (rowIndex == board.length) {
                res.add(generate(board));
                return;
            }

            //iterate over each row
            for (int colIndex = 0; colIndex < board.length; colIndex++) {
                if (isValid(board, rowIndex, colIndex)) {
                    board[rowIndex][colIndex] = 'Q';
                    helper(board, res, rowIndex + 1);//move to next row and determine if Q can be placed
                    board[rowIndex][colIndex] = '.'; // unchoose if valid placement not found
                }
            }
        }

        //convert board to List
        private List<String> generate(char[][] board) {
            List<String> list = new ArrayList<>();

            for (char[] row : board) {
                StringBuilder sb = new StringBuilder();
                for (char c : row) {
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            return list;
        }

        //check for false conditions else return true
        private boolean isValid(char[][] board, int rowIndex, int colIndex) {
            //return false if Q is in the same column
            for (int i = rowIndex - 1; i >= 0; i--) {
                if (board[i][colIndex] == 'Q') return false;
            }

            //check diagonal left to right from top down for Q
            for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') return false;
            }

            //check diagonal left to right from bottom up for Q
            for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 'Q') return false;
            }

            return true;
        }

    }
}
