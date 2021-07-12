// Time Complexity : O(n) * O(3^L)  n : number of cells in board and L - total length of word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes


class Solution {
   private int dirs[][];
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        //base case
        //check current character we are looking for is at board[i][j] index
        if(index == word.length()) 
            return true;

        if(r < 0 || c < 0 || r == m || c == n || word.charAt(index) != board[r][c]) 
            return false;

        //logic -- action
        char temp = board[r][c];
        board[r][c] = '#';

        //recurse
        for(int dir[]: dirs) {
            int i = dir[0] + r;
            int j = dir[1] + c;
            if(backtrack(board, word, i, j, index + 1)) return true;
        }
        //backtrack
        board[r][c] = temp;
        return false;
    }
}
