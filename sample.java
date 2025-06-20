
class Solution {

    public List<List<String>> solveNQueens(int n) {
        // 1. Create an empty board
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        // 2. Prepare result list
        List<List<String>> result = new ArrayList<>();

        // 3. Start backtracking from row 0
        dfs(board, 0, n, result);
        return result;
    }

    private void dfs(char[][] board, int row, int n, List<List<String>> res) {
        /* Base‑case: placed queens on all rows */
        if (row == n) {
            res.add(construct(board));
            return;
        }

        /* Try every column in this row */
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // choose
                dfs(board, row + 1, n, res); // explore next row
                board[row][col] = '.'; // undo (backtrack)
            }
        }
    }

    private boolean isSafe(char[][] b, int r, int c, int n) {

        // 1. Check same COLUMN above
        for (int i = 0; i < r; i++)
            if (b[i][c] == 'Q')
                return false;

        // 2. Check upper‑left ↖ diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (b[i][j] == 'Q')
                return false;

        // 3. Check upper‑right ↗ diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++)
            if (b[i][j] == 'Q')
                return false;

        return true; // spot is safe
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}

//
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // base1
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1)
            return true;

        // logic
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, word, r, c + 1, index + 1) || dfs(board, word, r + 1, c, index + 1)
                || dfs(board, word, r, c - 1, index + 1) || dfs(board, word, r - 1, c, index + 1);
        board[r][c] = temp;

        return found;

    }
}
//