// Time Complexity :Exponential
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int m,n;
    int[][] dirs;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0){
            return false;
        }
        
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board, word, i, j)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    private boolean helper(char[][] board, String word, int i, int j){
        //base
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j]){
            return false;
        }
        
        //logic
        if(word.charAt(0)==board[i][j]){
            if(word.length()==1){
                return true;
            }
            visited[i][j]=true;
            for(int[] dir:dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(helper(board, word.substring(1), r, c)){
                    return true;
                }
            }

            //backtrack
            visited[i][j]=false;
        }
        
        return false;
    }
}