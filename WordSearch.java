package com.ds.rani.backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
//Approach:Using backtracking,whenever I am getting first character of word in matrix then
// I am visiting 4 neigbours of that cell to check for next characters

//Time Complexity:o(rows*cols(4^L)) where L is length of the word
//Space complexity:o(L) length of the word (if I consider call stack)

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt( 0 )) {
                    if (backtracking( board, row, col, 0, word ))
                        return true;
                }
            }
        }
        return false;
    }

    boolean backtracking(char[][] board, int row, int col, int strCurrIdx, String word) {

        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        //base case
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt( strCurrIdx ))
            return false;

        if (strCurrIdx == word.length() - 1)
            return true;


        //action
        char originalChar = board[row][col];
        board[row][col] = '*';

        //recurse
        for (int dir[] : dirs) {
            int r = dir[0] + row;
            int c = dir[1] + col;
            if (backtracking( board, r, c, strCurrIdx + 1, word ))
                return true;
        }
        //backtrack
        board[row][col] = originalChar;
        return false;
    }
}
