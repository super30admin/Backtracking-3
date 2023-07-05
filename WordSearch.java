// Time Complexity : O(m*n^k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: The exist method takes a 2D character array board and a word as input and returns a boolean indicating whether the word exists in the board.
// The backtrack method checks if a word can be formed starting from a specific position (i, j) in the board. It takes the current index idx of the word being checked, along with the current position (i, j)
public class WordSearch {
    private int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        // base
        if (idx == word.length())
            return true;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') {
            return false;
        }

        // logic
        if (board[i][j] == word.charAt(idx)) {
            // char temp = word.charAt(idx);
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if (backtrack(board, word, idx + 1, nr, nc))
                    return true;
            }
            board[i][j] = word.charAt(idx);
        }
        return false;
    }

    public static void main(String[] args) {
        // Create an instance of WordSearch
        WordSearch wordSearch = new WordSearch();

        // Define the board and word to search
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";

        // Check if the word exists in the board
        boolean exists = wordSearch.exist(board, word);

        // Print the result
        System.out.println("Word '" + word + "' exists: " + exists);
    }
}
