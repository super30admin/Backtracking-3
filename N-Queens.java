// Time Complexity = O(N)
// Space Complexity = O(n^2)

class Solution {
    private List<List<String>> result;
    private boolean board [][];
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0, n);
        return result;
    }
    
    private void backtrack(int i, int n){
        // base case 
        if(i == n){
            List<String> currArr = new ArrayList<>();
            for(int k = 0; k<n;k++){ // row
                StringBuilder currString = new StringBuilder();
                for (int m = 0; m<n ; m++){ //column
                    if(board[k][m]){
                        currString.append('Q');
                    }
                    else{
                        currString.append('.');
                    }
                }
                currArr.add(currString.toString());
            }
            result.add(currArr);
        }
        // logic
        
        for(int j =0; j < n;j ++){
            if(isSafe(i,j, n)){
                //action
                board[i][j] = true;
                //recurse
                backtrack(i+1, n);
                //backtrack
                board[i][j] = false;
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        for(int i = 0; i < r; i++){
            if(board[i][c]) return false;
        }
        int i = r;
        int j = c;
        //right daigonal
        while(i >=0 && j<n){
            if(board[i][j]) return false;
            i--;j++;
        }
        i = r;
        j = c;
        //left daigonal
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--; j--;
        }
        return true;
    }
}