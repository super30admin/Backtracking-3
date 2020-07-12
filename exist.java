// Time Complexity :O(n3^l) n is the length of the board array and l is the length of the string.
// Space Complexity :O(1) n is the length of the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :I'm confused with the time and space complexity



class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        } 
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        //base case
        
        if(i<0 || i> n-1 || j<0 || j > m-1 || board[i][j]=='#' || board[i][j] != word.charAt(index)) return false;
        if(index == word.length()-1) return true;
        
        //logic
        //action
        char temp = board[i][j];
        board[i][j] = '#';
        //recurse
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for(int [] dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if (dfs(board, word, r, c, index + 1)) return true;
        }
        //backtrack
        board[i][j] = temp;
        return false;
    }
}