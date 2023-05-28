
// Time: O(m*n) * 3^L --- L = length of word
// Space: O(N^2)

class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j< n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, 0, i,j)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid ,String word ,int idx, int r , int c){
        // 
        if(idx == word.length()){
            return true;
        }

        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if(nr>=0 && nc>=0 && nr< grid.length && nc< grid[0].length && grid[nr][nc] == word.charAt(idx)){
                char temp =grid[nr][nc];
                grid[nr][nc] = '#';
                dfs(grid,word, idx+1 , nr, nc);
                grid[nr][nc] = temp;
            };
        }
        return false;

    }
}