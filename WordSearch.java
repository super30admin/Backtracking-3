// Time Complexity : O(m * n * 4^L) where L is length of the word
// Space Complexity : O(L) recursive stack space of length of the word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to first identify the position of the word's first letter in the board and then leverage helper dfs
method to recursively traverse in all 4 directions to check if we are able to find next letters of the word in
the traversal. At any point, if we dont find or boundaries are not met, we return false. If we reach the end of
the length of the word, it means we found the word and return true.It is important to backtrack by visit and unvisit
if a direction doesnt lead us as required. Also, to optimize, we perform a frequency check of number of times a
character is appearing in the board vs word, if at any time, the count doesnt match, we return false at the start
itself.
 */
class Solution {
    int m, n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1,0}};
        int[] wordCount = new int[128];

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                char ch = board[i][j];
                wordCount[ch]++;
            }
        }

        for(int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            wordCount[ch]--;
            if(wordCount[ch] < 0)
                return false;
        }



        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0))
                        return true;
                }

            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index == word.length())
            return true;

        if(i < 0 || j < 0 || i == m || j == n)
            return false;

        if(board[i][j] != word.charAt(index))
            return false;

        board[i][j] = '#';

        for(int[] dir : dirs) {
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            if(dfs(board, word, newRow, newCol, index + 1))
                return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}