// Time Complexity :  O(N!) no of queens
// Space Complexity : O(N) - No of queens
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    List<List<String>> res;
    int m;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new int[n][n];
        m = n;
        backtrack(0);
        return res;
    }
    private void backtrack(int r){
        //base
        if(r == m){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++ ){
                    if(board[i][j] == 0){
                        sb.append('.');
                    }else{
                        sb.append('Q');
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        
        //logic
        
        for(int j = 0 ; j < m; j++){
            if(isSafe(r, j)){
                //visited
                board[r][j] = 1;
                //action
                backtrack(r + 1);
                //backtrack
                board[r][j] = 0;
            }  
        }
    }
    
    private boolean isSafe(int i, int j){
        int r = i;
        int c = j;
        for(int k = 0; k <= r; k++){
            if(board[k][c] == 1){
                return false;
            }
        }
        //diagonal up left
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }
        r = i;
        c = j;
        //diagonal up right
        while(r >= 0 && c < m){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c++;
        }
        
        return true;
    }
}
