//https://leetcode.com/problems/word-search/
/*
Time: O(N. 3^L) since we won't go back to where we come from; where N is the no: of cells in the board. L is the length of the word. where N = m*n
Space: O(L)  + O(m*n) for visited array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class WordSearch1 {
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // once we see the 1st char we call the search method
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // search method is just going to do recursive calls on the neighbouring
    // adjacent letters
    private boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;

        // boundary check
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
                || visited[i][j])
            return false;

        visited[i][j] = true;
        if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
                || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

}
