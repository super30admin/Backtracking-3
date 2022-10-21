package Backtracking-3;

public class problem2 {
 //TC:- Exponential || m*n * 3^L L is length of word
 //SC:- O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.length() == 0 ) return false;
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int r, int c, int index){
        //base
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;
        
        //logic 
        if(board[r][c] == word.charAt(index)){
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            
            //recursion
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(helper(board, word, nr, nc, index +1)){
                    return true;
                }
            }
            //backtrack
            board[r][c] = ch;
            
        }
        return false;
    }
}
