// # Backtracking-3

// ## Problem1 
// N Queens(https://leetcode.com/problems/n-queens/)

// Time Complexity : O(n!)
// Space Complexity : O(n! * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    List<List<String>> result;
    boolean [][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.grid = new boolean[n][n];
        helper(0, n);
        return result;
        }

    private void helper(int r, int n){
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n ; j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }else{
                       sb.append('.'); 
                    }
                    
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        
        //
        for(int c=0; c<n; c++){
            if(isSafe(r, c)){
                grid[r][c] = true;
                helper(r+1, n);
                grid[r][c] = false;
            }
        }

    }

    private boolean isSafe(int r, int c){
        for(int i=0; i<r; i++){
            if(grid[i][c]){
                return false;
            }
        }
        int i = r;
        int j = c;
        while(i>=0 && j>=0){
            if(grid[i][j]){
                return false;
            } i--; j--;
        }
        i = r;
        j = c;
        while(i>=0 && j<grid.length){
            if(grid[i][j]){
                return false;
            } i--; j++;
        }
        return true;
    }

}


// Time Complexity : O(4 ^ l * m * n)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// ## Problem2
// Word Search(https://leetcode.com/problems/word-search/)

class Solution {
    private int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        dirs = new int[][]{{0, 1},{1, 0},{-1, 0}, {0, -1}};
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length()) return true;
        if(i < 0 || j< 0 || i==board.length || j ==board[0].length || board[i][j] == '#') return false;
        {
           
         if(board[i][j] == word.charAt(idx)){
                board[i][j] = '#';
                for(int [] dir: dirs){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(backtrack(board,r,c, word, idx+1)) return true;
                }

                board[i][j] = word.charAt(idx);
            }
            return false;
        }
    }
}