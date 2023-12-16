// Time Complexity :O(m*n*(3^L))
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    boolean flag;
    int m, n;
    String word;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {

        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        this.word = word;
        this.flag = false;
        this.m = board.length;
        this.n = board[0].length;

        //O(m*n)
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(board, i, j, 0);
                if(flag) return true;;
            }
        }

        return false;
    }

    //O(3^L) -> L = length of word
    private void dfs(char[][] board, int row, int col, int index) {

        //base
        if(index == word.length()) {
            flag = true;
            return;
        }

        if(row<0 || col<0 || row==m || col==n || board[row][col] == '#') return;
        if(board[row][col] != word.charAt(index)) return;

        //logic

        //action
        board[row][col] = '#';
        for(int[] dir: dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            //recurse
            dfs(board, r, c, index+1);
        }
        //backtrack
        board[row][col] = word.charAt(index);
    }
}