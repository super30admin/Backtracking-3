class Solution {
    // DFS + Backtracking
    // Time complexity is O(m*n*3^L) [exponential] where L is the length of the word
    // Space complexity is O(m*n + L{consider L as height of the tree}) 
    // where L is the length of the word
    // This solution is submitted on leetcode with zero errors
    private boolean found;
    private int[][] dirs;
    public boolean exist(char[][] board, String word) {
        //Edge case
        if(board == null || board.length == 0) return false;
        dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    helper(board,word, i, j,0);
                }
            }
        }
        return found;
    }
    
    private void helper(char[][] board, String word, int r, int c, int i){
        
        // base case
        if(i== word.length()){
            found = true;
            return;
        }
        
        if(r<0 || c< 0 || r==board.length || c==board[0].length || board[r][c] == '#') return;
        
        // logic
        if(board[r][c] == word.charAt(i)){
            //action
            board[r][c] = '#';
            //recurse
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                helper(board, word, nr, nc, i+1);
            }
            //backtrack
            board[r][c] = word.charAt(i);
        }
    }
}