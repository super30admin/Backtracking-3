// Time Complexity : O(M * N)(3 ^ K) where k is length of word 
// Space Complexity : O(K) due to internal stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We iterate over matrix and as soon as we find a first char of word we are lookinh for, we start backtracking.
 * During backtrack, we check all 4 neibours for next matching char and mark current char as visited.
 * We continue this until we have matched all chars from word else we stop backtracking and continue our search till all cells are checked.
*/



class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)return false;
        
        for(int r = 0; r < board.length;r++){
            for(int c = 0; c < board[0].length;c++){
                if(board[r][c] == word.charAt(0)){
                    if(backtrack(board, r, c, word, 0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, String word, int index){
        //base
        if(index == word.length())return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)return false;
        if(board[row][col] != word.charAt(index))return false;
        
        
        //logic
        char ch = board[row][col];
        board[row][col] = '#';
        
        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];
            
            if(backtrack(board, nr, nc, word, index+1))return true;
        }
        board[row][col] = ch;
        
        return false;
    }
}