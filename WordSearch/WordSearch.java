/* Time Complexity : O(m*n.3^l) 
 *  m - rows of the board
 * 	n - cols of the board
 * 	L - length of the input string - word */
/* Space Complexity : O(h)
 * 	h - height of the recursion stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//for loop backtrack solution

class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};// right, left, top, bottom

        //find the position of the first char in the given word and call the recursive method
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, word, i, j, 0)) return true;                            
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int idx){
        //base case
        if(idx == word.length()) return true;
        if(i < 0 || i == m || j < 0 || j == n) return false;        
        //logic
        if(board[i][j] == word.charAt(idx)){
            //action - replace char with #
            board[i][j] = '#';
            //recurse
            for(int[] dir: dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(helper(board, word, nr, nc, idx + 1)) return true;
            }
            //backtrack - change itback to the origina char
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}