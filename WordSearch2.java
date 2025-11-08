/**
 * Word Search (LeetCode 79: https://leetcode.com/problems/word-search/)
 * Approach: Backtracking/DFS - Try to match the word starting from each cell, marking visited cells.
 * Time Complexity: O(M*N*3^L), where M,N are board dimensions and L is word length.
 * Space Complexity: O(L) for recursion stack.
 */

public class WordSearch2 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, 0, i, j, word))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int idx, int r, int c, String word) {

        if (idx == word.length()) {
            return true;
        }

        //base
        if (r < 0 || c < 0 || r == board.length || c == board[0].length) {
            return false;
        }

        //logic
        if (word.charAt(idx) == board[r][c]) {
            //action
            board[r][c] = '#';
            for (int[] dir : dirs) {
                int cr = r + dir[0];
                int cc = c + dir[1];
                //recursion
                if (dfs(board, idx + 1, cr, cc, word))
                    return true;
            }
            //backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch2().exist(
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
