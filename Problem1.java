
// Time: O(N!)
// Space: O(N^2)


class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] grid = new int[n][n];
        helper(0,grid);
        return res;
    }

    public void helper(int r, int[][] grid ){
        if(r == grid.length){
            List<String> li = new ArrayList<>();
            for(int i =0 ; i< grid.length ; i ++){
                StringBuilder str = new StringBuilder();
                for(int j =0 ; j<grid[0].length ; j++){
                    if(grid[i][j] == 1)
                        str.append('Q');
                    else
                        str.append('.');
                }
                li.add(str.toString());
            }
            res.add(new ArrayList<>(li));
            return;
        }

        for(int c= 0 ; c < grid[0].length ; c++){
            if(isPossible(grid,r,c)){
                grid[r][c] = 1;
                helper(r+1, grid);
                grid[r][c] =0;
            }
        }
    }

    public boolean isPossible(int[][] grid , int i, int j){
        // check diagonal left
        int r = i, c = j;
        while(r>=0 && c >= 0 && r< grid.length && c< grid.length){
            if(grid[r][c] == 1){
                return false;
            }
            r--;c--;
        }

        r = i;
        c = j;

        // check diagonal right
        while(r>=0 && c < grid[0].length && r< grid.length && c>=0){
            if(grid[r][c] == 1){
                return false;
            }
            r--;c++;
        }
        
        r = i;
        c = j;
        // check columns
        while(r>=0 && r< grid.length && c>=0 && c< grid.length){
            if(grid[r][c] ==1){
                return false;
            }
            r--;
        }
        return true;
    }
}