// Time Complexity : 3^L * N (3 choices at every node and n is number of elements as we are visiting all nodes)
// Space Complexity : L (length of the word) (as all those letters would be in recurssive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        //try to find first letter in board
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (exist(board, r, c, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int r, int c, char[] word, int i) {
        if (i == word.length)
            return true;
        //check boundary condition & if letter not found
        if (r<0 || c<0 || r == board.length || c == board[0].length || board[r][c] != word[i])
            return false;

        char tmp = board[r][c];
        board[r][c] = '#'; //mark as visited

        //check in all 4 directions
        if(exist(board, r, c+1, word, i+1)
                || exist(board, r, c-1, word, i+1)
                || exist(board, r+1, c, word, i+1)
                || exist(board, r-1, c, word, i+1))
            return true;

        board[r][c] = tmp; //backtrack
        return false;
    }
}