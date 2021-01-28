/*
Backtracking because we have to "find all combinations"
Space Complexity: O(N*M);
Time Complexity: O(N!); 

*/




class Solution {
    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    
    private void backtrack(int r){
        //base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder(); 
                for(int j = 0; j < m; j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j = 0; j < m; j++){
            if(isSafe(r,j)){
                //action
                board[r][j] = 1;
                //recurse
                backtrack(r+1);
                //backtrack
                board[r][j] = 0;
            }
        }
        
    }
    
    private boolean isSafe(int r, int c){
        //column up
        for(int k = 0; k < r; k++){
            if(board[k][c] == 1) return false;
        }
        
        //diagonal up left
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        i = r;
        j = c;
        //diagonal up right
        while(i >= 0 && j < m){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}