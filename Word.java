// Time Complexity : O(MxN)
// Space Complexity : O(MxN)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(dfs(i, j, board, arr, 0)) {
                    return true;   
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, char[] arr, int index) {
        if( index == arr.length) {
            return true;
        }
        Boolean result;
        if( 0 <= i && i < board.length && 
                0 <= j && j < board[i].length &&
                board[i][j] == arr[index]) {
				
            // mark this position as visited for the current DFS
			board[i][j] = '.';       
            result = dfs(i+1, j, board, arr, index+1) || 
                     dfs(i-1, j, board, arr, index+1) || 
                     dfs(i, j+1, board, arr, index+1) || 
                     dfs(i, j-1, board, arr, index+1);   
             // remove mark on the position and restore original character
			 board[i][j] = arr[index];
            return result;
        }
        return false;        
    }
}