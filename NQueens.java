import java.util.ArrayList;
import java.util.List;

public class NQueens{
    List<List<String>> res = new ArrayList<>();
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        helper(n, 0);
        return res;
    }

    //for loop based backtrack
    private void helper(int n, int row){
        //base 
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder str =new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == true){
                        str.append("Q");
                    }else{
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            res.add(list); 
            return;
        }

        //logic 
        for(int c = 0; c < n; c++){
            if(isSafe(row, c, n)){
                //check if this is valid and can place here     
                board[row][c] = true;
                helper(n, row+1);
                board[row][c] = false; //backtrack cause the board is not possible so need to fix previous positions 
            }
        }

    }

    private boolean isSafe(int r , int c, int n ){
        int i = r, j = c;
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }
        
        r = i;
        c = j;
        //diagonal left
        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--;
            c--;
        }
         r = i;
         c = j;
        //diagonal right
        while(r >= 0 && c < n){
            if(board[r][c]) return false;
            r--;
            c++;
        }

        return true;
    }
}