/** Given an m x n board and a word, find if the word exists in the grid.
* TC O(3 pow N). SC O(length of word)
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m;i++) {
            for(int j = 0; j < n ;j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int row, int col, int index, String word) {
        if (index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) 
            return false;
        if (board[row][col] == word.charAt(index)) {
            char ch = board[row][col];
            board[row][col] = '#';
            int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
            for (int[] dir : dirs)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if (dfs(board, r, c, index+1, word)) {
                    board[row][col] = ch;
                    return true;
                }
            }
            board[row][col] = ch;
        }
      
       return false;
    }
     
}
