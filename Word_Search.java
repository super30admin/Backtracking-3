/*

Approach: since we have connected components, we can go for bfs and dfs.
But along with connected components we have the requirement of 
backtracking to mark unvisited so we can only use DFS(keep track of the parent). 
Because BFS does not maintain hierarchy of check for parent.

*/

/*

    Time: O(3^l), l = lenght of word
    Space: O(l), where l is the length of the word.

 */

class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}}; // LRTB
        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(board, i, j, word, 0)) return true; // implies that we identified the word
            }
        }
        return false; // not found
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {

        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false; // base case

        if(board[i][j] != word.charAt(idx)) return false;

        // action
        board[i][j] = '#'; // mark as visited

        // recurse
        for(int[] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(dfs(board, r, c, word, idx+1)) return true;
        }

        // backtrack
        board[i][j] = word.charAt(idx);

        return false;

    }
}