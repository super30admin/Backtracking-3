import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(N!)
//Space Complexity : O(N^2)
class Solution {
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0) return result;
        m=n;
        boolean board[][] = new boolean[n][n];
        backtrack(board,0);
        return result;
    }
    public void backtrack(boolean board[][],int r){
        //base 
        //out of bounds
        if(r == m){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < r; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                    sb.append('.');
                    } 
                }
                 list.add(sb.toString());
            }
            result.add(list);
           
        }
        //logic
        //iterating on all columns for particular row
        for(int c = 0; c < m; c++){
            if(isSafe(board, r, c)){
                //action
                board[r][c] = true;
                //recurse
                backtrack(board , r+1);
                //backtrack
                board[r][c] = false;
            }
            
        }
    }
    private boolean isSafe(boolean board[][],int r, int c){
        //check in same column above
         for(int i = 0; i < r; i++){
             if(board[i][c]) return false;
         }
        //diagonal up
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]) return false;
            i--;j--;
        }
        i = r;  j = c;
         while(i >= 0 && j < m){
            if(board[i][j])return false;
            i--;j++;
        }
        return true;
    }
}