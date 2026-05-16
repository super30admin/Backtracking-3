// Time Complexity : O(m * n * 4^L) where m and n are board dimensions and L is the length of the word
// Space Complexity : O(L) for recursion stack depth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to start searching from every cell in the board and recursively explore all four directions to match the characters of the target word.
// If the current character matches, we temporarily mark the cell as visited so it is not reused again in the same search path.
// Backtracking restores the original character after recursion so that other possible paths can be explored correctly.

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (backtrack(board, word, i, j, 0, dirs)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int idx, int[][] dirs) {
        if (idx == word.length()) return true;

        if (r<0 || c<0 || r==board.length || c==board[0].length || board[r][c] == '#') return false;

        if(board[r][c] == word.charAt(idx)) {
            // action
            board[r][c] = '#';

            // recurse
            for(int[] dir: dirs) {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if (backtrack(board, word, nr, nc, idx+1, dirs)) {
                    return true;
                }
            }
            
            // backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}