// Time complexity = O((m*n)*(4^word.length))
// Space complexity = O(word.length), the length of the tree.

// Logic - backtracking when you choose a specific path using dfs and it does not work out because the character is not equal to the chosen path 
// then what happens is that you backtrack and go the right path
// why dfs works and bfs does not work
// cause in dfs we know the specific path like we know the parent from which the child is coming.
// but in bfs we do not know the parent, so the parent is lost and there is no way we can backtrack
// in this specific case, knowing a single path which dfs gives is mandatory.
class Solution {
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        for(int i=0;i< m;i++) {
            for(int j=0;j< n;j++) {
                if(backtrack(board, word, 0, i, j )) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int idx, int i, int j) {
        if(idx== word.length()) {
            return true;
        }

        if(i<0 || j<0 || i>=m || j>=n  ) {
            return false;
        }
        if(board[i][j] == word.charAt(idx)) {
            // action
            board[i][j] = '#';
            // recurse
            for(int[] dir: dirs) {
                int nr =   i+ dir[0];
                int nc =   j+ dir[1];
                if(backtrack(board, word, idx+1, nr, nc )) 
                    return true;               
            }
            // backtrack
            board[i][j] = word.charAt(idx);
            
            
        }
        return false;
    }
}