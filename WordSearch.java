
//Time Complexity: O(N 3^L)
//Space Complexity: O(L)

 

class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length-1;
        int cols = board[0].length-1;
        boolean[][] marked = new boolean[rows+1][cols+1];

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (dfs(board, row, col, word, 0, marked)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int row, int col, String word, int idx, boolean[][] marked) {
        if (row > board.length-1 || row < 0 || col > board[0].length-1 || col < 0|| board[row][col] != word.charAt(idx)) {
            return false;
        }
        
        if (board[row][col] == '#') {
            return false;
        }
       
        
        if (idx == word.length() -1) {
            return true;
        }
       char ch = board[row][col];

        board[row][col] = '#';
        
        boolean res = dfs(board, row+1, col, word, idx+1, marked) || 
                      dfs(board, row-1, col, word, idx+1, marked) ||
                      dfs(board, row, col+1, word, idx+1, marked) ||
                      dfs(board, row, col-1, word, idx+1, marked);

        board[row][col] = ch;
        return res;
    }
}
