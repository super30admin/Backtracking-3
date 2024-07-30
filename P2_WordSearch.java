// TC: mn 3^L
// SC: L
class Solution {
    boolean flag = false;
    private void dfs(char[][] board, int i, int j, int wordIdx, String word, int[][] directions) {
        if(flag == true)
            return;
        if(wordIdx == word.length()) {
            flag = true;
            return;
        }

        for(int[] dir: directions) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if(row >=0 && col >= 0 && row < board.length && col < board[0].length && board[row][col] != '1') {
                if(board[row][col] == word.charAt(wordIdx)) {
                    char c = board[row][col];
                    board[row][col] = '1';
                    dfs(board, row, col, wordIdx+1, word, directions);
                    board[row][col] = c;
                }
            }
        }
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int [][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    char c = board[i][j];
                    board[i][j] = '1';
                    dfs(board, i, j, 1, word, directions);
                    board[i][j] = c;
                    
                }
            }
        }
        return flag;
    }
}