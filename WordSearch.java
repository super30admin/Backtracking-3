//TC: M*N 4(N) - M*N for finding the first char, 4(N)for traversin with DFS with backtracking
//SC: O(M*N) - For the recursive stack

class WordSearch {
    char placeholder = '.';

    boolean isExist;
    public boolean existPractise(char[][] board, String word) {
        // Sanitization
        // Iterate to find the first letter of the word.
        // DFS - Direction Array
        // If we found the next char
        // Move forward.
        // Action
        // Recurse
        // Backtrack

        if (board == null || board[0].length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        char firstChar = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == firstChar) {
                    helper(board, word, i, j, 0); 
                    if(isExist) {
                        return true;
                    }
                }
            }
        }
        return isExist;
    }

    private void helper(char[][] board, String word, int i, int j, int wordIndex) {
        //Base
        if(word.length()-1 == wordIndex) {
            isExist = true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = placeholder;
        int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int row = dir[0] + i;
            int column = dir[1] + j;
            if (row >= 0 && row < board.length && column >= 0 && column < board[0].length && board[row][column] == word.charAt(wordIndex+1)) {
                helper(board, word, row, column,wordIndex+1);
            }
        }
        board[i][j] = temp;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        // char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        char[][] board = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D'} };
        boolean isExist = wordSearch.existPractise(board, "AAB");
        System.out.println("The word exists"+isExist);
    }

}
