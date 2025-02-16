
/**
 * Time Complexity: O(m*n*3^k) where k is the length of word, in worst case, we check all 3 directions for a character in word
 * Space Complexity: O(k), k is the length of word
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * Iterate Through the Grid - Traverse each cell of the board to find the starting character of word.
 * Depth-First Search (DFS) with Backtracking: 
 * Recursively explore all four directions (up, down, left, right). If a character matches, continue searching for the next character.
 * Mark visited cells temporarily to avoid revisiting in the same path. Backtrack by restoring the original character after exploring.
 * If index == word.length(), return true (word found). If out of bounds or character mismatch, return false.
 * Return Result: If any path forms the word, return true, else return false.
 */

public class WordSearch {

    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        int start = 0;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(start)) {
                    if (recurse(board, 0, word, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean recurse(char[][] board, int index, String word, int row, int col) {
        if (index == word.length()) {
            return true; // Found the full word
        }

        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == '#' || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or already visited or mismatch
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (recurse(board, index + 1, word, nr, nc)) {
                return true;
            }
        }

        board[row][col] = temp; // Restore for backtracking
        return false;
    }

    public static void main(String[] args) {
        // Your code here
    }
}
