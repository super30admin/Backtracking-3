// Time Complexity : O(m^2 * n^2), mn time we do dfs each of which is O(mn)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//use DFS. DFS is a version of backtrack. Find the matching character and iterate it's neighbours to find further character matches from the word.
//Mark visited each node and put it back to original once done.

class Solution {
    
    //neighbour traverse
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        
        
        int m = board.length; //row
        if(m==0) return false; //sanity check
        
        int n = board[0].length; //col
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                    if(backtrack(board, word, i, j, 0)){
                        return true;
                    }
            }
        }
        
        return false;
        
    }
    
    private boolean backtrack(char[][] board, String word, int row, int col, int cursor){
        
        
        //success
        if(cursor == word.length()){
            return true;
        }
        

        //check for validity and word match
        if(isValid(board, row, col) && board[row][col] == word.charAt(cursor)){
            
        char remember = board[row][col];
        board[row][col] = '$'; //visited
            
        //start traversing    
        for(int k=0; k<4; k++){
            int x = row + dx[k];
            int y = col + dy[k];
           
            if(backtrack(board, word, x, y, cursor+1)){
                return true;
            }            
        }
            
            board[row][col] = remember;
    }
        
        return false;
    }
    
    //out of bounds checks
    private boolean isValid(char[][] board, int i, int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }
}