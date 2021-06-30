public class WordSearch {


    public boolean exist = false;
    public boolean[] visited;

    /*
    TC : O(N*3^L) since we are searching for each of N characters and we are essentially going in 3 directions and the one we can in from.
            where L is the length of word
     SC : Same order as above
     LC : Yes
     Problems faced> : No
     */

    /**
     * The approach taken is straightforward. We iterate over the char array and for each char we go in all four directions,
     * marking the previous character as visited so that we dont go back in the direction we came in from.
     * Once we reach end of string and we found a matching character then we have found the word
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int size = board.length * board[0].length;
        if (size < word.length())
            return false;
        visited = new boolean[size];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                helper(board, word, 0, visited, i, j);
            }

        return exist;
    }

    public void helper(char[][] board, String word, int index, boolean[] visited, int r, int c) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int visitedIndex = r * board[0].length + c;
        if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && !visited[visitedIndex]) {
            if (board[r][c] == word.charAt(index) && !visited[visitedIndex]) {
                if (index == word.length() - 1) {
                    exist = true;
                    return;
                }

                visited[r * board[0].length + c] = true;
                for (int[] dir : dirs) {
                    int sr = r + dir[0];
                    int sc = c + dir[1];
                    helper(board, word, index + 1, visited, sr, sc);


                }
                if (visitedIndex < board[0].length * board.length && visitedIndex >= 0)
                    visited[visitedIndex] = false;

            }


        }
    }

}
