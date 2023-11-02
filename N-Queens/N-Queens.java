/* Time Complexity : O(n.n!) 
 *  n - number of queens to be placed */
/* Space Complexity : O(n^2)
 * 	O(n^2) - boolean grid that we prepared */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//for loop backtrack solution

class Solution {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        grid = new boolean[n][n];

        helper(0, n);
        return result;
    }

    private void helper(int r, int n){
        //base condition
        if(r == n){// All the n- queens are placed in the grid
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
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
        //logic
        //In a row, check at each cell if it is safe to place the queen
        for(int c = 0; c < n; c++){
            if(isSafe(r,c)){
                //action
                grid[r][c] = true;
                //recurse
                helper(r+1,n);
                //backtrack
                grid[r][c] = false;
            }
        }
    }

    private boolean isSafe(int r, int c){
        //col above
        for(int i = 0; i < r; i++){
            if(grid[i][c]) return false;
        }
        //top left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0){
            if(grid[i][j]) return false;
            i--;
            j--;
        }
        //top right
        i = r; 
        j = c;
        while(i >= 0 && j < grid.length){
            if(grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}