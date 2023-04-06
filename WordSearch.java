/*The time complexity of this implementation is O(mn3^L) where
* L is the length o the word and space complexity is O(L)*/
class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if(visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = search(board, word, visited, i + 1, j, index + 1)
                || search(board, word, visited, i - 1, j, index + 1)
                || search(board, word, visited, i, j + 1, index + 1)
                || search(board, word, visited, i, j - 1, index + 1);
        visited[i][j] = false;
        return result;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch solution = new WordSearch();
        boolean exists = solution.exist(board, word);
        System.out.println(exists); // prints true
    }

}
