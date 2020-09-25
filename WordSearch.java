// Time Complexity : O(n*m) 
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Backtracking
class Solution {
    
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0)
            return false;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtracking(board, word, i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    private boolean backtracking(char[][] board, String word, int i, int j, int index){
        //base case
        if(index >= word.length()-1){
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        for(int[] dir : directions){
            int r = i+ dir[0];
            int c = j + dir[1];
            
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && word.charAt(index+1)==board[r][c]){
                if(backtracking(board, word, r, c, index+1))
                    return true;
            }
        }
        board[i][j] = temp;
        return false; 
    }
}