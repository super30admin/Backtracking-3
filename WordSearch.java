// Time Complexity : O((m*n)3^l)  l is length of the word
// Space Complexity : O(L) l is length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[][] dirs;
    int m,n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        m = board.length;
        n = board[0].length;
        this.flag = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!flag){
                    helper(board, i, j,word,0);
                }
            }
        }
        return flag;
    }

    private void helper(char[][] board,int i, int j, String word, int idx) {

        //base
        if(idx == word.length()){
            flag = true;
            return;
        }

        if(i < 0 || j < 0 || i == m || j ==n || board[i][j] == '#' ) return;

        //
        if(word.charAt(idx) == board[i][j]){
            board[i][j]= '#';
            for(int[] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                helper(board, nr, nc, word, idx+1);
            }
            board[i][j]= word.charAt(idx);
        }
    }
}