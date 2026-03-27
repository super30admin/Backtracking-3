    /**
    Time Complexity : O(N!)
    Explanation:
    We try placing a queen in each column for every row.
    In worst case, number of configurations grows factorially.
    For each placement, we check safety in O(N).

    Space Complexity : O(N^2)
    Explanation:
    Board takes O(N^2) space and recursion stack goes up to N.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially struggled with validating safe positions for queens.
    Fixed it by checking:
        1) Same column (upward)
        2) Left diagonal
        3) Right diagonal
    Also needed to carefully backtrack (place → recurse → remove)
    to explore all valid configurations.
    */
    class Solution {



        List<List<String>> result;
    
        public List<List<String>> solveNQueens(int n) {
    
            this.result = new ArrayList<>();
            boolean[][] board = new boolean[n][n];
    
            helper(n, 0, board);
            return result;
        }
    
        private void helper(int n, int r, boolean[][] board) {
    
            // Base case: all queens placed
            if (r == n) {
    
                List<String> li = new ArrayList<>();
    
                for (int i = 0; i < n; i++) {
                    StringBuilder row = new StringBuilder();
    
                    for (int j = 0; j < n; j++) {
                        if (board[i][j]) row.append('Q');
                        else row.append('.');
                    }
    
                    li.add(row.toString());
                }
    
                result.add(li);
                return;
            }
    
            // Try placing queen in each column
            for (int c = 0; c < n; c++) {
    
                if (isSafeToPlace(n, r, c, board)) {
    
                    board[r][c] = true;
    
                    helper(n, r + 1, board);
    
                    // Backtrack
                    board[r][c] = false;
                }
            }
        }
    
        private boolean isSafeToPlace(int n, int i, int j, boolean[][] board) {
    
            int r, c;
    
            // Check column (up)
            r = i;
            c = j;
            while (r >= 0) {
                if (board[r][c]) return false;
                r--;
            }
    
            // Check left diagonal
            r = i;
            c = j;
            while (r >= 0 && c >= 0) {
                if (board[r][c]) return false;
                r--;
                c--;
            }
    
            // Check right diagonal
            r = i;
            c = j;
            while (r >= 0 && c < n) {
                if (board[r][c]) return false;
                r--;
                c++;
            }
    
            return true;
        }
    }