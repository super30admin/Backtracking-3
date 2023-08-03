// Time Complexity : O(3^L), L is the length of the word.
// Space Complexity : O(L), L is the length of the word.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Use dfs and backtrack to find the word in the board.
 * 2. Recursively check for each character in the board in all directions, 
 *  if the word was not found in one direction backtrack to prev character and go in other direction.
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[] flag = new boolean[1];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!flag[0])
                    helper(board, i, j, 0, word, dirs, flag);

                if(flag[0])
                    return true;
            }
        }

        return false;
    }

    private void helper(char[][] board, int row, int col, int i, String word, int[][] dirs, boolean[] flag){
        if(i == word.length()){
            flag[0] = true;
            return;
        }

        if(row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] == '.'){
            return;
        }

        if(board[row][col] != word.charAt(i))
            return;

        board[row][col] = '.';
        for(int[] dir : dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if(!flag[0])
                helper(board, nr, nc, i+1, word, dirs, flag);
        }
        board[row][col] = word.charAt(i);
    }
}