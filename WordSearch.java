//TC: O((m*n)*3^l), where l is length of word to be searched
//SC: O(m*n) for visited matrix
//approach: backtracking with DFS

public class WordSearch {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int rows;
    int cols;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) return false;

        if (word.charAt(0) == board[i][j]) {
            if (word.length() == 1) return true;

            visited[i][j] = true;
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                if (dfs(board, word.substring(1), r, c)) return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
