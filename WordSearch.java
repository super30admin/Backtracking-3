// Time complexity: O(N x 3^L) where N is the length of the board and L is the length of the word
// Space complexity: O(L)
// Run on leetcode: Yes
// Issues: None

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, 1, i, j) == true)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int index, int i, int j){
        if(index == word.length())
            return true;
        boolean res = false;
        char temp = board[i][j];
        board[i][j] = '#';
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int[] dir: dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y] == word.charAt(index)){
                res =  dfs(board, word, index+1, x, y);
                if(res==true)
                    break;
            }
        }
        board[i][j] = temp;
        return res;
    }
}
