// Time Complexity : O(n!)
// Space Complexity : O(n^2)
class Solution {
    List<List<String>> res;
    int n;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
       if(n==0) return new ArrayList<>();
       res= new ArrayList<>();
       this.n=n;
        grid = new boolean[n][n];
        backtrack(0);
        return res;
    }
    
    private void backtrack(int row){
        
        //base
        
        if(row==n){
            List<String> list=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(grid[i][j]==true){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                    
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        
        for(int col=0;col<n;col++){
            
            if(isSafe(row,col)){
                    //action
                
                    grid[row][col]=true;
                    //recurse

                    backtrack(row+1);

                    //backtrack
                    grid[row][col]=false;
                }
        }
        
       
    }
    
    private boolean isSafe(int row, int col){
        //check col above
        for(int i=row-1; i>=0 ; i--){
            if(grid[i][col]==true) return false;
        }
    
        
        //check left diag
        int i=row-1, j=col-1;
        while(i>=0 && j>=0){
             if(grid[i][j]==true) return false;
            i--;
            j--;
        }
        
        //check right diag
        i=row-1; j=col+1;
        while(i>=0 && j<n){
             if(grid[i][j]==true) return false;
            i--;
            j++;
        }
        
        return true;
        
    }
    
    
}