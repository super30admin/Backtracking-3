// Time Complexity :O(n^n/2) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :I'm confused with the time and space complexity



class Solution {
    List<List<String>> result;
    int [][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        m = n;
        board = new int[n][n];
        backtrack(0);
        return result;
    }
    
    private void backtrack(int r){
        if(r == m){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<m;j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
            temp.add(sb.toString());
            
        }
            result.add(temp);
            return;
        }
        
        //logic
        for(int i = 0; i<m;i++){
            if(isSafe(r,i)){
                //action
                board[r][i] = 1;

                //recurse
                backtrack(r+1);

                //backtrack
                board[r][i] = 0;
            }
            
        }
    }
    
    private boolean isSafe(int i, int j){
        for(int k=0;k<m;k++){
            if(board[k][j]==1)return false;
        }
        int r = i-1; int c = j-1;
        while(c>=0 && r>=0){
            if(board[r][c] == 1) return false;
            c--;
            r-- ;
        }
        r = i-1; c = j+1;
         while(r>=0 && c<m){
            if(board[r][c] == 1) return false;
            r--;
            c++;
         }
        
        return true;
    }
}