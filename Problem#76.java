// WORD SEARCH

// Time Complexity : 3^L, where L is the length of the string
// Space Complexity : L, where L is the length of the string, which is also the max length of the recursion tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null)
            return false;
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, 0, i, j, m, n))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int idx, int r, int c, int m, int n){
        //base
        if(idx == word.length())
            return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#')
            return false;
        //logic
        if(word.charAt(idx) == board[r][c]){
            //action
            board[r][c] = '#';
            //recurse - All 4 directions - RBLU
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, idx + 1, nr, nc, m, n))
                    return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}