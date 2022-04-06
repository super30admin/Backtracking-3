// Time Complexity : O(3^L) -> l - length of string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    
    private int dirs[][];
    int m; int n;
    
    public boolean exist(char[][] board, String word) {
        //null case
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        //iterate over the matrix
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int r, int c, int idx) {
        //base case
        if(idx == word.length()) return true;
        if(r<0 || r==m || c<0 || c==n || board[r][c] == '#') return false;
        //logic
        if(board[r][c] == word.charAt(idx)) {
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            //recurse
            for(int [] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(backtrack(board, word, nr, nc, idx+1)) return true;
            }
            //backtrack
            board[r][c] = ch;
        }
        return false;
    }
}