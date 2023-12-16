import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // TC:O(n^2)
    // SC:O(n^2)
        List<List<String>> result;
        boolean[][] board;
        public List<List<String>> solveNQueens(int n) {
            this.result = new ArrayList<>();
            this.board = new boolean[n][n];
            helper(0,n);
            return result;
        }
        private void helper(int row, int n){
            // base case
            if(row == n){
                List<String> temp = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < n; j++){
                        if(board[i][j]){
                            sb.append("Q");
                        }else{
                            sb.append(".");
                        }
                    }
                    temp.add(sb.toString());
                }
                result.add(temp);
                return;
            }
            // logic
            for(int j = 0; j < n; j++){
                if(isSafe(row, j, n)){
                    //action
                    board[row][j] = true;
                    //recurse
                    helper(row+1, n);
                    //backtrack
                    board[row][j] = false;
                }
            }
        }
        private boolean isSafe(int i, int j, int n){
            int r = i;
            int c = j;
            while(r >= 0){
                if(board[r][c])
                    return false;
                r--;
            }
            r = i;
            c = j;
            while(r>=0 && c>= 0){
                if(board[r][c])
                    return false;
                r--; c--;
            }
            r = i;
            c = j;
            while(r>=0 && c < n){
                if(board[r][c])
                    return false;
                r--; c++;
            }
            return true;
        }
    }

