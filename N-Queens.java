// TC : O(n!)
// SC : O(n^2)
// for loop based recursion, backtrack

class Solution {
    boolean[][] temp;
    int n;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
    
        result = new ArrayList<>();
        if(n == 0) return result;
        this.n = n;
        
        temp = new boolean[n][n];
        
        backtrack(0);
        
        return result;
        
    }
    
    private void backtrack(int row) {
        
        if(row == n) {
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(temp[i][j] == true)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                ans.add(sb.toString());
            }
            result.add(ans);
        }
        //System.out.println(n);
        
        for(int col = 0; col < n; col++) {
            //System.out.println("here");
            if(isSafe(row, col)) {
                temp[row][col] = true;
                
                backtrack(row+1);
                
                temp[row][col] = false;
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        // col check

        for(int j = row - 1; j >= 0; j--) {
            if(temp[j][col] == true) return false;
        }
        //upper left diagnol check
        int i = row-1, j = col-1;
        while(i >= 0 && j >= 0) {
            if(temp[i][j] == true) return false;
            i--;
            j--;
        }
        // upper right dignol check
        i = row-1;
        j = col+1;
        while(i >= 0 && j < n) {
            if(temp[i][j] == true) return false;
            i--;
            j++;
        }
        return true;
    }
}
