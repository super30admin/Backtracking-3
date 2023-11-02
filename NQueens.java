// Time Complexity : O(n*n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class NQueens {
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
            //base
            if(r == n){
                List<String> li = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < n;j++){
                        if(grid[i][j]){
                            sb.append("Q");
                        }
                        else{
                            sb.append(".");
                        }
                    }
                    li.add(sb.toString());
                }
                result.add(li);
            }

            //logic
            for(int c = 0; c < n; c++){
                if(isSafe(r, c)){
                    //action
                    grid[r][c] = true;
                    //recurse
                    helper(r+1, n);

                    //backtrack
                    grid[r][c] = false;
                }
            }
        }

        private boolean isSafe(int i, int j){
            int r = i, c = j;
            //column
            for(int k = 0; k < r; k++){
                if(grid[k][c])
                    return false;
            }

            r = i; c = j;
            //left-up
            while(r >= 0 && c >= 0){
                if(grid[r][c])
                    return false;
                r--;
                c--;
            }

            r = i; c = j;
            //right-up
            while(r >= 0 && c < grid.length){
                if(grid[r][c])
                    return false;
                r--;
                c++;
            }
            return true;
        }
    }
}
