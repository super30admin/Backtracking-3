// Time Complexity : O(3^(N))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For each node we have 3 directions to search for (eliminating the direction we came from)
    While backtracking we add back the element which was previously present.
*/

class Solution {
    
    int c;
    int r;
    public boolean exist(char[][] board, String word) {
        
        c = board.length;
        r = board[0].length;
        
        for (int i=0; i<c; i++){
            for (int j=0; j<r; j++){
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean backtrack(char[][] board, String word, int index, int i, int j){
        
        if (index == word.length())
            return true;
        
        if (i<0 || i==c || j<0 || j==r || index > word.length())
            return false;
        
        if (word.charAt(index) == board[i][j]) {
            
            char temp = word.charAt(index);
            
            board[i][j] = '#';
            
            int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
            for (int [] dir : dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if (backtrack(board, word, index+1, r, c))
                    return true;
            }
            
            board[i][j] = temp;
        }
        return false;
    }
}