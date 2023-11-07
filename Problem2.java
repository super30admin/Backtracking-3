// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int[][] dirs;
    private boolean helper(int r,int c,boolean[][] visited,int idx,char[][] board, String word){
        if(idx == word.length())
            return true;
        if(r < 0 || r >= visited.length || c < 0 || c >= visited[0].length || idx > word.length()|| board[r][c]!=word.charAt(idx)||visited[r][c])
        return false;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            visited[r][c] = true;
            if(helper(nr,nc,visited,idx+1,board,word))
                return true;;
            visited[r][c]=false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(i,j,visited,0,board,word))
                        return true;
                }

            }
        }
        return false;

    }
}