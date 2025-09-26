//TC: O(m * n * 3 ^ L) -> L is the length of the word
//SC: O(L)
public class WordSearch {

    private final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#') return false;

        if (board[i][j] != word.charAt(index)) return false;

        board[i][j] = '#';
        for (int[] dir: dirs) {
            int nr = dir[0] + i, nc = dir[1] + j;
            if (backtrack(board, nr, nc, word, index + 1)) return true;
        }

        board[i][j] = word.charAt(index);
        return false;
    }

    public static void main(String[] args) {
        final WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][] {
                {'A', 'E', 'E', 'D'},
                {'S', 'C', 'F', 'S'},
                {'B', 'D', 'E', 'E'}
        }, "SCFEESDEE"));

        System.out.println(wordSearch.exist(new char[][] {
                {'A', 'E', 'E', 'D'},
                {'S', 'C', 'F', 'S'},
                {'B', 'D', 'E', 'E'}
        }, "SFCEA"));

        System.out.println(wordSearch.exist(new char[][] {
                {'A', 'E', 'E', 'D'},
                {'S', 'C', 'F', 'S'},
                {'B', 'D', 'E', 'E'}
        }, "BDEFCFE"));
    }
}
