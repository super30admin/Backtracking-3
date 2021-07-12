//  Time Complexity: O(n!)
//  Space Complexity: O(n ^ 2)


class Solution {
    boolean [][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0,n);
        return result;
    }
    
    private void backtrack(int r, int n){
        //base
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i <n ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j]){
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
        for(int j = 0; j < n; j++){
            if(isSafe(r,j,n)){
                //action
                board[r][j] = true;
                //recurse
                backtrack(r+1,n);
                //backtrack
                board[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        //column up
        for (int i = 0 ; i < r; i++){
            if(board[i][c]) return false;
        }
        
        //diagonal up left
        int i = r ; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--; j--;
        }
        
        //diagonal up right
        i = r ; j = c;
        while(i >= 0 && j < n){
            if(board[i][j]) return false;
            i--; j++;
        } 
        return true;
    }
}