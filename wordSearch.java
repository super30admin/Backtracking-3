// Time Complexity : O(m*n*4^l) where m, n are the dimension of the grid and l is the length of the word to
// be searched
// Space Complexity : O(l) where l is the length of the word to be searched (recursive call length is l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class wordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        // base case
        if (index == word.length()) {
            return true;    
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        // logic
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, index + 1, word) ||
                        dfs(board, i - 1, j, index + 1, word) ||
                        dfs(board, i, j + 1, index + 1, word) ||
                        dfs(board, i, j - 1, index + 1, word);
        // replace before backtracking
        board[i][j] = temp;
        return found;
    }
}