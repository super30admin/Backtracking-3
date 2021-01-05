// Time Complexity :O(3^N) where N is length of word
// Space Complexity : O(N) where N is length of word
// Did this code successfully run on Leetcode :Yes

class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int row, int col, int index){
        //base case
        if(index == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length  || col < 0 || col >= board[0].length){
            return false;
        }
        //logic
        if(board[row][col] == word.charAt(index)){
            //action
            char temp = board[row][col];
            board[row][col] = '#';
            for(int[] dir: dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                //recurse
                if(backtrack(board, word, r, c, index + 1)){
                    return true;
                }
            }
            //backtrack
            board[row][col] = temp;
        }
        
      return false;  
    }
}