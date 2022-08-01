//Time Complexity : n*n-2*n-4*n-6=n!
//space complexity:n*n = I'm using the recursive stack space and using grid.
//Microsoft 
//Using backtracking
//There will be on one Queen in Each row,exhaustive approach - I place a queen if it doesn't workout i'll come back and check left and right diagonal if their is no queen.If Queen is placed and they are not attacking each other.first place queen is placed first row and first column then jump to the next it was not safe then we go back to the previous element placed queen.should not bother about checking the column in same row no.Running n every place there will be 'n' elements.

class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[][] grid;
    int n;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return result;
        
        grid = new boolean[n][n];
        this.n = n;
        backtrack(0);
        return result;
    }
    private void backtrack(int row){
        //base 
        if(row == n){
            List<String> answer = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<n;j++){
                    if(grid[i][j] == true){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                answer.add(sb.toString());
            }
            result.add(answer);
            return;
        }
        //logic
        for(int i = 0;i<n;i++){
            if(isSafe(row,i)){
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row+1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int r, int c){
        //check the column first
        for(int i = r-1;i>=0;i--){
            if(grid[i][c] == true){
                return false;
            }
        }
        //check the left diagonal
       int i = r ,j=c;
        while(i>=0 && j>=0){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        //check the right diagonal
        i = r;j=c;
        while(i>=0 && j<n){
            if(grid[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}