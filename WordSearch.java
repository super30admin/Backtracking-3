// TIme Complexity: O(mxn(2^n))
// Space Complexity with recursive stack: O(mxn)
class Solution {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.length() == 0) {
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] board, int row, int col, String word, int c) {
        if(c == word.length()) {
            return true;
        }

        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(c)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '0';
        if(helper(board, row+1, col, word, c+1) ||
                helper(board, row-1, col, word, c+1) ||
                helper(board, row, col+1, word, c+1) ||
                helper(board, row, col-1, word, c+1)) {
            return true;
        }
        board[row][col] = temp;

        return false;
    }
}