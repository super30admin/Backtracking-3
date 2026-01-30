public class WordSearch {
    // Directions: up, down, right, left
    private int[][] dirs;
    private int m, n;
   /*
   Time Complexity - O(m * n * 4^L) where L = word.length()
   Space Complexity - O(L) recursion stack in the worst case.
    */
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        this.m = board.length;
        this.n = board[0].length;

        // Try starting the DFS from every cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if DFS succeeds, return true immediately
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS (backtracking) to match word[idx...] starting from board[i][j].
     */
    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        // Base case: we've matched all characters
        if (idx == word.length()) return true;

        // Out of bounds or already visited
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;

        // Current cell must match the current character in word
        if (board[i][j] != word.charAt(idx)) return false;

        // Mark as visited (so we don't reuse the same cell in this path)
        char saved = board[i][j];
        board[i][j] = '#';

        // Explore 4 neighbors
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (dfs(board, x, y, word, idx + 1)) {
                // Restore before returning
                board[i][j] = saved;
                return true;
            }
        }

        // Backtrack: restore the original value before returning
        board[i][j] = saved;
        return false;
    }

    // Testing
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(ws.exist(board1, "ABCCED")); // true
        System.out.println(ws.exist(board1, "SEE"));    // true
        System.out.println(ws.exist(board1, "ABCB"));   // false

        char[][] board2 = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        System.out.println(ws.exist(board2, "AAB")); // true
    }
}
