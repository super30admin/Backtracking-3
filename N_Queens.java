//Time complexit: O( n! )
//Space Complexity: O(n^2)- because of the board size 
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] grid = new boolean[n][n];
        helper(grid,0,result);
        return result;
    }
    private void helper(boolean [][] grid,int r, List<List<String>> result){
        //base
        if(r==grid.length){
            //boolean-->list<string>
            List<String> li= new ArrayList<>();
            for(int i=0;i<grid.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<grid.length;j++){
                    if(grid[i][j]){
                        sb.append("Q");
                    }else sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int c=0;c<grid.length;c++){
            if(isSafe(grid,r,c)){
                //action
                grid[r][c]=true;
                //recurse
                helper(grid,r+1,result);
                //backtrack
                grid[r][c]=false;
            }
        }
    }
    private boolean isSafe(boolean[][] grid,int r,int c){
        //col
        for(int i=0;i<r;i++){
            if(grid[i][c]){
                return false;
            }
        }
        //diagonal up left 
        int i=r; 
        int j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]) return false;
            i--;j--;
        }
        //diagonal up right
        i=r; 
        j=c;
        while(i>=0 && j<grid.length){
            if(grid[i][j]) return false;
            i--;j++;
        } 
        return true;
    }
}