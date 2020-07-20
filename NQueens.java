//Time Complexity: O(N!)
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueen(board, 0, n);
        return result;
    }
    
    private void placeQueen(int[][] board, int r, int n){
        //Base Case
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1) sb.append("Q");
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //Logic
        for(int i = 0; i < n; i++){
            if(isSafe(board, r, i, n)){
                board[r][i] = 1;
                placeQueen(board, r + 1, n);
                //backtrack
                board[r][i] = 0;
            }
        }
    }
    
    private boolean isSafe(int[][] board, int i, int j, int n){
        for(int k = 0; k < i; k++){
            if(board[k][j] == 1) return false;
        }
        int x = i - 1;
        int y = j - 1;
        while(x >= 0 && y >= 0){
            if(board[x][y] == 1) return false;
            x--;y--;
        }
        
        x = i - 1;
        y = j + 1;
        while(x >= 0 && y < n){
            if(board[x][y] == 1) return false;
            x--;y++;
        }
        return true;
    }
}
