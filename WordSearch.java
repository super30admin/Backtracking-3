// Time Complexity :O(mn3^l) where l is length of word
// Space Complexity :recursive stack contains O(l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we are doing dfs at each index and inside dfs we are going all four directions to find next character,
//of word once we find all characters, we return true else if we are out of bounds or revisiting same char, we return false
class Solution {
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.println("i and j are"+i+" and "+j);
                if (helper(i, j, board, 0, word, dirs))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(int i, int j, char[][] board, int index, String word, int[][] dirs) {
        // edge
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#')
            return false;
        // logic

        char w = word.charAt(index);
        char c = board[i][j];
        // System.out.println("w and c are"+w+" and "+c);
        // System.out.println("row and col are"+i+" and "+j);
        if (w == c) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (helper(row, col, board, index + 1, word, dirs))
                    return true;

            }
            board[i][j] = c;
        }
        return false;
    }
}