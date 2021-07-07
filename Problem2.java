// Time Complexity : O((m*n)*3^L)  L=length of string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private int[][] dirs;
    int m , n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        m= board.length; n= board[0].length;
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        //base
        //check if curr char that we are looking at i,j index of my board
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || word.charAt(index) != board[r][c])
            return false;
        //logic 
        //action
        char temp = board[r][c];
        board[r][c] = '@';
        //recurse
        for(int [] dir : dirs){
            int i= r+dir[0];
            int j= c+dir[1];
            if(backtrack(board, word, i, j, index+1)) return true;
        }
        //backtrack
        board[r][c] = temp;
        return false;
    }
}