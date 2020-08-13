/*
// Time Complexity : O(4^n)
// Space Complexity : O(l) l = length of the string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/
class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length;j++){
                if(board[i][j] == word.charAt(0) &&
                   dfsHelper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsHelper(char[][] board, String word,int r, int c, int indx){

        //if indx >= word.length, we know we found the word.
        if(indx >= word.length())
            return true;

        if(r < 0 || r >= board.length ||
           c < 0 || c >= board[0].length ||
           board[r][c] != word.charAt(indx)){
            return false;
        }

        //store board[r][c] value.
        char ch = board[r][c];
        //change to make sure we do not walk over it again.
        board[r][c] = '0';
        int direction[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int dir[] : direction){
            if(dfsHelper(board, word,r+dir[0],c+dir[1], indx+1))
                return true;
        }
        //backtrack, change back for next iteration.
        board[r][c] = ch;
        return false;
    }
}
