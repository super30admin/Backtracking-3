// Time Complexity : O(m * n * 3^L), where m=rows, n=cols, L=Length of word, 3 since we check the other 3 sides
// Space Complexity : O(L)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// We use backtracking to solve this, we maintain visited by changing the character in the grid to a special symbol like # and backtrack if its not the correct character
// Once we find all the characters in thr string we will return true
class Solution {
    int[][] dirs;
    int m,n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        // U, L, D, R
        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int index) {
        // base
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') {
            return false;
        }

        // logic
        if (board[r][c] == word.charAt(index)) {
            char ch = board[r][c];

            // action
            board[r][c] = '#';

            //recurse
            // trying out all the 4 directions to see if we find the next character in word
            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, word, nr, nc, index+1)) {
                    return true;
                }
            }

            //backtrack
            board[r][c] = ch;
        }

        return false;
    }
}