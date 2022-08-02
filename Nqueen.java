// Time Complexity : O(N!)
// Space Complexity : O(NXN)
// Did it run on Leetcode: Yes
class Solution {
    List<List<String>> res;
    boolean[][] grid;
    int n;
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n==0){
            return res;
        }
        grid = new boolean[n][n];
        this.n = n;
        backtrack(0);
        return res;
    }
    void backtrack(int r){
        if(r==n){
            List<String> ans = new ArrayList<>();
            for(int i=0;i<grid.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<grid.length;j++){
                    if(grid[i][j]==true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            res.add(ans);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(r,i)){
                grid[r][i] = true;
                backtrack(r+1);
                grid[r][i] = false;
            }
        }
    }
    boolean isSafe(int r,int c){
        for(int i=r-1;i>=0;i--){
            if(grid[i][c] == true){
                return false;
            }
        }
        int i=r;
        int j = c;
        while(i>=0&&j>=0){
            if(grid[i][j]==true){
                return false;
            }
            i--;
            j--;
        }
        
        i=r;
        j = c;
        while(i>=0&&j<n){
            if(grid[i][j]==true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}