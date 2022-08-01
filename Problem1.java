//Time Complexity: O(n!)
//Space Complexity: O(n^2)
//Code run successfully on LeetCode.

public class Problem1 {

    List<List<String>> result;
    boolean[][] grid;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        grid = new boolean[n][n];
        
        helper(n,0);
        return result;
    }
    
    private void helper(int n, int r){
        
        if(r == n){
            
            List<String> newList = new ArrayList<>();
            
            for(int i =0; i <n; i++){
                
                StringBuilder sb = new StringBuilder();
                
                for(int j =0; j < n; j++){
                    
                    if(grid[i][j] == false)
                        sb.append(".");
                    else
                        sb.append("Q");
                }
                
                newList.add(sb.toString());
            }
            
            result.add(newList);
            return;
        }
        
        for(int j =0; j < n; j++){
            
            if(isSafe(n,r,j))
            {
                grid[r][j] = true;
                helper(n, r+1);
                grid[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(int n, int r, int c){
        
        for(int i = r-1; i>=0; i--){
            
            if(grid[i][c])
                return false;
        }
        
        int i =r -1;
        int j =c -1;
        
        while(i >=0 && j >=0){
            
            if(grid[i][j])
                return false;
            
            i--;
            j--;
        }
        
        i = r -1;
        j = c +1;
        
        while(i >=0 && j < n){
            
            if(grid[i][j])
                return false;
            
            i--;
            j++;
        }
        
        return true;
    }
}
