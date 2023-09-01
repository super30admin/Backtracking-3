//TC: each row n, n-1,n-2, .. options to place queen so O(n!)
//SC: O(n^2) space of boolean board
class Solution {
    List<List<String>> result;
    int m; //no of queens
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        m = n;
        helper(board, 0);
        return result;
    }
    
    private void helper(boolean[][] board , int r){
        //base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i=0; i<m; i++){
                 StringBuilder sb = new StringBuilder();
                for(int j=0; j<m; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //logic
        //check if cell is safe
        for(int c=0; c<m; c++){
            //action
            if(isSafe(board, r, c)){
                board[r][c] = true;
                //recurse
                helper(board, r+1);
                //backtrack
                board[r][c] = false;
            }
        }     
    }
    
    private boolean isSafe(boolean[][] board , int r, int c){
        
        //check in same upper column
        for(int i=0; i<r;i++){
            if(board[i][c]) return false;
        }
        //upper left diagonal
        int i = r;
        int j = c;
        while(i >=0 && j >= 0){
            if(board[i][j]) return false;
            i--; j--;
        }
        //upper right diagonal
        i = r;
        j = c;
        while(i >=0 && j < m){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }  
}
