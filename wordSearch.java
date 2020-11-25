// Time Complexity :  O(M*N *3 ^ L) no of elements
// Space Complexity : O(L) - Length of string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int m = board.length; int n = board[0].length;
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n ;j++){
                if(dfs(board, word, 0, i ,j))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, int r, int c){
        if(index == word.length()) return true;
        if(r >= board.length || c >= board[0].length || r<0 || c<0 || board[r][c] == '#') return false;
        //logic
        if(board[r][c] == word.charAt(index)){
            char temp = board[r][c]; //marking visited
            
            //dfs in all directions
            for(int[] d : dirs){
                board[r][c] ='#';
                if(dfs(board, word, index + 1, r+ d[0], c + d[1])) return true;
                //replace the value back if it doesnt work
                board[r][c] = temp; 
            }
            
        }
        return false;  
    }
}