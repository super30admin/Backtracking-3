// Time Complexity : O(3^L) 
// Space Complexity : O(L) 
// L is the length of the word
/* Approach : To determine if a word exists in a 2D board, we use a backtracking approach where we start from each cell that matches 
the first character of the word and recursively explore all four possible directions (up, down, left, right). We mark cells as visited 
to avoid revisiting them within the same path. If we successfully match all characters of the word, we return true. 
If we reach a boundary or a mismatch, we backtrack by unmarking the cell and continue exploring other paths. This process continues 
until we either find the word or exhaust all possibilities.
 */
class Solution {
    // Directions array to move up, down, left, and right
    int[][] dirs;

    // Main method to check if the word exists in the board
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length;
        int n = board[0].length;
        // Initialize directions array
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the first character of the word matches the cell
                if (word.charAt(0) == board[i][j]) {
                    // Start the recursive search
                    if (helper(board, i, j, word, 0)) 
                        return true;
                }
            }
        }
        return false;
    }

    // Recursive helper method to search for the word
    private boolean helper(char[][] board, int r, int c, String word, int idx) {
        // Base case: if the entire word is found
        if (idx == word.length()) {
            return true;
        }
        // Check boundaries
        if (r < 0 || c < 0 || r == board.length || c == board[0].length) {
            return false;
        }

        // If the current cell matches the current character of the word
        if (board[r][c] == word.charAt(idx)) {
            // Mark the cell as visited
            board[r][c] = '#';

            // Explore all four directions
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // Recur for the next character in the word
                if (helper(board, nr, nc, word, idx + 1)) {
                    return true;
                }
            }
            // Backtrack and unmark the cell
            board[r][c] = word.charAt(idx);
        }

        return false;
    }
}
