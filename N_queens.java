import java.util.ArrayList;
import java.util.List;

public class N_queens {
    //TC: O(n^m)
    //SC: O(n)
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        backtrack(0, n);
        return result;
    }
    private void backtrack(int r, int n){
        //base
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){

                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int c=0; c<n; c++){
            if(isSafe(r, c, n)){
                //action
                board[r][c] = true;
                //recurse
                backtrack(r+1, n);
                //backtrack
                board[r][c] = false;
            }
        }
    }
    private boolean isSafe(int r, int c, int n){
        //column up
        for(int i=0; i<r; i++){
            if(board[i][c]){
                return false;
            }
        }
        int i=r; int j=c;
        //diagonal left up
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--; j--;
        }
        //diagonal right up
        i=r; j=c;
        while(i>=0 && j<=n-1){
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }
}
