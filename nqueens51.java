// Time Complexity : O(N!)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(0, new boolean[n][n], res);
        return res;
    }
    public void helper(int r, boolean[][] state, List<List<String>> res){
        if(r == state.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<state.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<state.length;j++){
                    if(state[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for(int c = 0;c<state.length;c++){
            if(isSafe(r,c,state)){
                state[r][c] = true;
                helper(r+1, state, res);
                state[r][c] = false;
            }
        }
    }

    public boolean isSafe(int r, int c, boolean[][] grid){

        for(int i = 0;i<r;i++){
            if(grid[i][c]) return false;
        }

        int i = r;
        int j = c;
        while(i>=0 && j<grid.length){
            if(grid[i][j]) return false;
            i--;
            j++;
        }
        i = r;
        j = c;
        while(j>=0 && i>=0){
            if(grid[i][j]) return false;
            j--;
            i--;
        }
        return true;
    }

    public List<String> converter(boolean[][] state){
        List<String> res = new ArrayList<>();
        for(int i = 0;i<state.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<state.length;j++){
                if(state[i][j]){
                    sb.append('Q');
                }
                else{
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}