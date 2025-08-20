//Time Complexity: O(M·N·3^{L-1}) in the worst case—each of the M·N starts branches to ≤3 new directions per remaining character.
//Space Complexity: O(L) auxiliary for the recursion depth

//Try to start the word from every cell; if the first letter matches, launch DFS.
//In DFS, mark the cell as visited (set to '#'), explore 4 neighbors for the next character, and backtrack (restore) on return.
//Stop early and return true as soon as you complete all characters; otherwise continue searching.

class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;

        if(board[i][j] != word.charAt(idx)) return false;

        //action
        board[i][j] = '#';

        //recurse
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(dfs(board, r, c, word, idx+1)) return true;
        }

        //backtrack
        board[i][j] = word.charAt(idx);

        return false;
    }
}
