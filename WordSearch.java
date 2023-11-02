// Time Complexity : O(n3^n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class WordSearch {
    class Solution {
        int[][] dirs;
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == word.charAt(0)){
                        if(dfs(board, word, i, j, 0)) return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int r, int c, int idx){
            //base
            if(idx == word.length())
                return true;
            if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#')
                return false;

            //logic

            if(board[r][c] == word.charAt(idx)){
                //action
                board[r][c] = '#';
                //recurse
                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(dfs(board, word, nr, nc, idx+1)) return true;
                }
                //backtrack
                board[r][c] = word.charAt(idx);
            }
            return false;
        }
    }
}
