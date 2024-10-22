// Time Complexity : O((mxn)(4^L))
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Backtracking-3;

public class Problem-2 {
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        this.dirs= new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i < m; i++){
            for(int j = 0;j < n;j++){
                if(backtrack(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx){
        //base
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r==board.length || c ==board[0].length) return false;

        //logic
        if(board[r][c] == word.charAt(idx)){
            //action
            board[r][c] = '#';
            //recurse
            for(int dir[]: dirs){
                int nr = dir[0] + r;
                int nc = dir[1]+ c;
                if(backtrack(board,nr, nc, word, idx+1)) return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}
