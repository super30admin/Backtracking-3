class Solution {
    /*
        TC - O(m * n * 3^L) - m * n are all possible starting cells, and 4 is the directions explored at each step and
         l is length of the word
        SC - O(L) where l is length of the word
        Solution - Iterate through every cell in the board. Whenever a cell matches the first character of the word, 
        start a DFS from that cell.
        DFS:
        If all characters have been matched (pos == word.length()), return true.
        If the current cell is out of bounds or already visited ('#'), return false.
        If the current character matches the corresponding character in the word:
        Mark the cell as visited by replacing it with '#'.
        Recursively search in the four directions (up, down, left, right).
        Restore the original character (backtrack) if no path is found.
        If none of the starting positions can form the word, return false.
    */
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }

        if (i == m || i < 0 || j == n || j < 0 || board[i][j] == '#') {
            return false;
        }

        if (board[i][j] == word.charAt(pos)) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if (helper(board, nr, nc, word, pos+1)) {
                    return true;
                }
            }
            board[i][j] = word.charAt(pos);
        }

        return false;
    }
}