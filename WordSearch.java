/*
* Approach:
*  1. check for the first letter of word in the board.
        if found, start applying dfs.
* 
*  2. over dfs, compare curr row and col with word index,
        mark the board cell as visited by converting letter into '#'.
    
        check the directions and recurse.

        backtrack by replacing the letter by '#' with word index.
* 
*  3. if row, col cross the edge or cell is visited return false
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O((m*n) * (3^L))
* 
* Space Complexity: O(L)
    L - Length of word
* 
*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0) && 
                    dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    int[][] directions = new int[][] {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length())
            return true;

        if (row < 0 || row == board.length ||
                col < 0 || col == board[0].length ||
                board[row][col] == '#')
            return false;

        if (word.charAt(index) == board[row][col]) {
            board[row][col] = '#';

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (dfs(board, nr, nc, word, index + 1))
                    return true;
            }

            board[row][col] = word.charAt(index);
        }

        return false;
    }
}
