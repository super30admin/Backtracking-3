package Backtracking-3;

public class problem1 {
//TC:- O(n!) where n is number of queens
 //SC:-  O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<List<String>> result;
    int n;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        
        if(n == 0) return result;
        
        grid = new boolean[n][n];
        this.n = n;
        
        helper(0);
        
        return result;
    }
    
    public void helper(int row){
        //base
        if(row == n){
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    
                    if(grid[i][j] == true){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }
        //logic
        for(int col = 0; col < n; col++){
         //action
            if(isSafe(row, col)){
                grid[row][col] = true;
                
            //recursive
            helper(row + 1);
            //backtrack
            grid[row][col] = false;
            }
            
        }
        
    }
    
    public boolean isSafe(int row, int col){
        //check above all
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == true){
                return false;
            }
        }
        
        //check all upper left
        int i = row - 1;
        int j = col - 1;
        
        while(i >= 0 && j >= 0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        
        //check all upper right
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
