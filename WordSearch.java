// Time complexity: O(m*n*32^l)
// Space complexity: O(L) where L = length of string 

// Approach
// start dfs at each node and keep going in all 4 directions (mark the visited node)
// till the char does not not match the string at the given index.
// if you reach the end of the word; then you found it; return true

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // will only start for first character in word
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = word.charAt(index);
        // wont be in the string
        board[row][col] = '0';

        if (dfs(row + 1, col, board, word, index + 1) || dfs(row - 1, col, board, word, index + 1)
                || dfs(row, col + 1, board, word, index + 1) || dfs(row, col - 1, board, word, index + 1)) {
            return true;
        } else {
            board[row][col] = temp;
            return false;
        }
    }
}