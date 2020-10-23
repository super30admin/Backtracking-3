// Time Complexity : O(n*3^k), where n is number of chars on the board, k is length of string 
// Space Complexity : O(k), for call stack depth

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// we try to search for the first char(from word) on the board, then call helper fn
// now our function has 3 choices to look for match of next char (we edit cur char to * to avoid going back, replace it when we finish visiting all neighbours)
// recursion proceed until char match till end of string
// else dont proceed and return false  

class Solution {
    char[][] board;
    int numRows, numCols; 
    String word;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word.length()==0) return false;
        
        this.board= board;
        this.numRows = board.length;
        this.numCols = board[0].length;
        this.word = word;
        
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(i, j, 0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(int r, int c, int index){
        //base case
        if(index==word.length()-1){
            return true;
        }
        
        char actualVal = board[r][c]; 
        board[r][c] = '*';
        
        for(int[] dir : dirs){
            int n_r = dir[0] + r;
            int n_c = dir[1] + c;
            
            if(n_r>=0 && n_r<numRows && n_c>=0 && n_c<numCols && board[n_r][n_c]==word.charAt(index+1)){
                if(helper(n_r, n_c, index+1)){
                    return true;
                }
            }
        }
        
        board[r][c] = actualVal;
        return false;
    }
}