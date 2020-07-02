// Time Complexity : O(m*n*3^L), where L = length of the word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class Solution {

    public boolean exist(char[][] board, String word) {
        for(int i=0;i <board.length;i++){
            for(int j=0;j <board[0].length;j++){
                if(helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, int index){
        
        //base
        if(index == word.length()) {
           return true;
        }
        
        if(i < 0 || i >= board.length || j <0 || j >= board[0].length){
           return false; 
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        //
        if(board[i][j] == word.charAt(index)){
            //action
            char temp = board[i][j];
            board[i][j] = '#';
            
            //recurse
            for(int[] dir:dirs) {
                int row = dir[0] + i;
                int col = dir[1] + j;
                
                if(helper(board, word, row, col, index+1)) return true;
            }
            //backtrack
            board[i][j] = temp;
        }
        
        return false;
    }
}