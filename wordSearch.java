// Time Complexity : O(n.3^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    private static int[][] dirs;

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        if (word.length() == 0)
            return true;
        // direction array
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // find the first char in board and start exploring from there
                if (board[i][j] == word.charAt(0)) {
                    if (backTrack(board, i, j, word, 0, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    // boolean based recursion
    private static boolean backTrack(char[][] board, int i, int j, String word, int index, int m, int n) {
        // base case
        // if index == word.length that means matched all the elements so we return true
        if (index == word.length())
            return true;

        // bound check and already visite node check
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        // System.out.println(index + " " + word.charAt(index));
        // main logic
        // check that our current element in the board matches with char at index of
        // word
        if (board[i][j] == word.charAt(index)) {
            // action
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                // recurse
                if (backTrack(board, r, c, word, index + 1, m, n))
                    return true;
            }
            // backTrack
            board[i][j] = word.charAt(index);
        }
        return false;

    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}