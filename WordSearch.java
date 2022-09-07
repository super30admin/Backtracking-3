//TC : O(n!)    n-> total no of cells
//SC : O(n*n)

class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        char c = word.charAt(0);
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(c == board[i][j]){
                    visited[i][j] = true;
                    if(helper(board,i,j,1,word,visited))
                        return true;
                    visited[i][j] = false;
            }
        }
        }
        return false;
    }
    
    private boolean helper(char[][] board,int r,int c,int idx, String word,boolean[][] visited){
        //base
        if(idx >= word.length())
            return true;
        //logic
        for(int[] dir:dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if(nr >=0 && nr < m && nc >=0 && nc < n && board[nr][nc]==word.charAt(idx) && !visited[nr][nc]){
                //System.out.println(word.charAt(idx));
                visited[nr][nc] = true;
                if(helper(board,nr,nc,idx+1,word,visited))
                        return true;
            visited[nr][nc] = false;
            }
        }
        return false;
    }
}
