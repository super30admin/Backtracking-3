// Word Search(https://leetcode.com/problems/word-search/)

// Time Complexity : O(n x m x 3^l) l is length of word
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start at the place in board where char is the char at 0th index of word. Then recurse to all other characters in all directions and
 * mark all visited with # and go for next char of word.
 */
class Solution {
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int r, int c, int idx, String word){
        //base
        if(idx == word.length()) return true;
        if(r<0 || c< 0 || r == board.length || c == board[0].length || board[r][c]=='#'){
            return false;
        }
        //logic
        if(board[r][c] == word.charAt(idx)){
            board[r][c] = '#';
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(helper(board, nr, nc, idx+1, word)) return true;
            }
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}