// Time Complexity : O(N* 3powerL) where N is total no. of cells and L is length of word
// Space Complexity : O(L) the recursive stack height equal to length of word
// Did this code successfully run on Leetcode : Yes

class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, i, j, 0))
                    return true;
                else
                    continue;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length())
            return true;
        if(i<0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(word.charAt(index) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            for(int[] dir: dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                if(backtrack(board, word, r, c, index+1))
                    return true;
            }
            board[i][j] = temp;
        }
        
        return false;
    }
}