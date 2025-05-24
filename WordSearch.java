// Time Complexity : O(m * n * 3^L), m=no of rows, n=no of cols, L= len of word, each DFS goes to 3 directions
// Space Complexity : O(L), recursion stack upto Len of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - For each cell in the board, initiate a DFS to check if the word can be formed starting from that cell.
//   - During DFS, mark the cell as visited using a placeholder (like '#') to avoid revisiting.
//   - At each step, check if the current cell character matches the current word character.
//   - Explore all 4 directions and backtrack by restoring the original character.

public class WordSearch {
    int[][] dirs;
    int m, n;

    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j = 0; j <n; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if(idx == word.length()) {
            return true;    //found word
        }

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') {
            return false;
        }

        if(board[i][j] != word.charAt(idx)) {
            return false;
        }

        //action
        board[i][j] = '#';

        //recurse
        for(int[] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(dfs(board, r, c, word, idx + 1)) {
                return true;
            }
        }

        //backtrack
        board[i][j] = word.charAt(idx);

        return false;
    }

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();

        char[][] originalBoard = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        // Make deep copy of board each time
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println("Word ABCCED exists: " + solver.exist(deepCopy(originalBoard), word1));  // true
        System.out.println("Word SEE exists: " + solver.exist(deepCopy(originalBoard), word2));      // true
        System.out.println("Word ABCB exists: " + solver.exist(deepCopy(originalBoard), word3));     // false
    }

    // Helper to deep copy board
    private static char[][] deepCopy(char[][] board) {
        char[][] copy = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }
}
