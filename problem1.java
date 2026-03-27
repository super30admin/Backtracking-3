    /**
    Time Complexity : O(M * N * 4^L)
    Explanation:
    - We start DFS from each cell → M * N
    - For each step, we explore up to 4 directions
    - Depth of recursion = length of word (L)
    So worst case: O(M * N * 4^L)

    Space Complexity : O(L)
    Explanation:
    Recursion depth can go up to length of the word.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially forgot to mark visited cells, which caused revisiting
    the same cell and incorrect paths.
    Fixed it by marking the cell as '#' during recursion and restoring
    it after backtracking.
    Also needed to carefully handle boundary conditions and base case
    when the entire word is matched.
    */

    class Solution {


        public boolean exist(char[][] board, String word) {
    
            int m = board.length;
            int n = board[0].length;
    
            int[][] adj = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
            // Try starting from every cell
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
    
                    if (board[i][j] == word.charAt(0)) {
                        if (helper(board, i, j, adj, word, 0, m, n)) {
                            return true;
                        }
                    }
                }
            }
    
            return false;
        }
    
        private boolean helper(char[][] board, int r, int c, int[][] adj,
                               String word, int idx, int m, int n) {
    
            // Base case: matched entire word
            if (idx == word.length()) {
                return true;
            }
    
            // Boundary + mismatch check
            if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != word.charAt(idx)) {
                return false;
            }
    
            // Mark visited
            char temp = board[r][c];
            board[r][c] = '#';
    
            // Explore all 4 directions
            for (int[] dir : adj) {
                int nr = r + dir[0];
                int nc = c + dir[1];
    
                if (helper(board, nr, nc, adj, word, idx + 1, m, n)) {
                    return true;
                }
            }
    
            // Backtrack
            board[r][c] = temp;
    
            return false;
        }
    }