import java.util.*;
// Time Complexity : O(m * n * 4^N), where m,n are grid dims and N = word length.
//                   From each cell we branch up to 4 directions; pruning/visiting cuts many paths.
// Space Complexity : O(L) recursion depth (call stack). We modify the board in-place (no extra visited set).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Be careful to restore the character after exploring (backtracking).
//
// Approach (Backtracking):
// - Try to start matching the word from every cell.
// - At each step, if the current cell matches word[idx], mark it as visited (e.g., '#'),
//   then recursively search its 4 neighbors for idx+1.
// - If any path succeeds, return true. Otherwise, restore the cell and backtrack.
// - Early prune on bounds, visited cells, or character mismatch.
public class WordSearch {
    int m, n;
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        // Try every starting cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j) {
        // All characters matched
        if (idx == word.length()) return true;

        // Bounds or visited or mismatch
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Choose: mark visited
        char saved = board[i][j];
        board[i][j] = '#';

        // Explore neighbors
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            if (dfs(board, word, idx + 1, r, c)) {
                board[i][j] = saved; // optional immediate restore on success
                return true;
            }
        }

        // Un-choose: restore
        board[i][j] = saved;
        return false;
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();

        char[][] b1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println("Expect true (ABCCED): " + sol.exist(copy(b1), "ABCCED"));
        System.out.println("Expect true (SEE): " + sol.exist(copy(b1), "SEE"));
        System.out.println("Expect false (ABCB): " + sol.exist(copy(b1), "ABCB"));

        char[][] b2 = {
                {'a','b'},
                {'c','d'}
        };
        System.out.println("Expect false (abcd): " + sol.exist(copy(b2), "abcd"));

        char[][] b3 = {
                {'A'}
        };
        System.out.println("Expect true (A): " + sol.exist(copy(b3), "A"));
        System.out.println("Expect false (B): " + sol.exist(copy(b3), "B"));
    }

    // Helper to avoid mutating test boards across runs
    private static char[][] copy(char[][] g) {
        char[][] h = new char[g.length][g[0].length];
        for (int i = 0; i < g.length; i++) h[i] = Arrays.copyOf(g[i], g[i].length);
        return h;
    }
}
