//Time: O(n!)
//Space: O(n*n)
class Solution {
    List<List<String>> result;
    int n;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0)
            return result;
        
        this.n = n;
        grid = new boolean[n][n];
        helper(0);
        
        return result;
    }
    
    private void helper(int row){
        if(row == n){
            List<String> answer = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(grid[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }
        
        for(int col = 0; col < n; col++){
            if(isSafe(row,col)){
                grid[row][col] = true;
                helper(row + 1);
                
            }
            grid[row][col] = false;
        }
    }
               
    private boolean isSafe(int row, int col){
        //cols
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == true)
                return false;
        }
        //left diagonal
        int i = row -1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(grid[i][j])
                return false;
            i--;
            j--;
        }
        //right diagonal
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n){
            if(grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }

}
