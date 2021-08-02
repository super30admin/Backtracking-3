// Time Complexity : exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    int[][] dirs;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0) return true;
        
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        m = board.length;
        n = board[0].length;
        
        //find the first letter in the entire matrix and call the helper to check
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //didn't find the first letter so move on
                if(board[i][j] != word.charAt(0)){
                    continue;
                }
                if(helper(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, int r, int c, String word, int index){
        //base
        if(index == word.length())
            return true;
        
        if( r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(index))
            return false;
        //logic
        board[r][c] = '#'; 
        
        //using dirs array move in all 4 sides 
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(helper(board, nr, nc, word, index + 1)) return true;
        }
        
        //backtrack
        board[r][c] = word.charAt(index);
        return false;
        
        
    }
}