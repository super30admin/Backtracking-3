// Time Complexity : O(4^L) everytime we have 4 options to choose from
// Space Complexity : O(L) size of recursive stack ~ length of string to search
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    boolean res;
    int[] dx = new int[]{-1,0,0,1};
    int[] dy = new int[]{0,1,-1,0};
    public boolean exist(char[][] board, String word) {
        res = false;
        for(int i = 0; i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    char t = board[i][j];
                    board[i][j] = '*';
                    helper(i,j,1,board, word);
                    if(res == true) return true;
                    board[i][j] = t;
                }
            }
        }
        return res;
    }

    public void helper(int i, int j, int k, char[][] board, String word){
        if(k == word.length()){
            res = true;
            return;
        }
        for(int d = 0;d < dx.length;d++){
            int x = dx[d]+i;
            int y = dy[d]+j;
            if(isValid(x,y,board, word.charAt(k))){
                char val = board[x][y];
                board[x][y] = '*';
                helper(x,y,k+1, board, word);
                board[x][y] = val;
            }
        }
    }

    public boolean isValid(int i, int j, char[][] board, char val){
        if(i>=0 && j>=0 && i<board.length && j< board[0].length){
            return board[i][j] == val;
        }
        return false;
    }
}