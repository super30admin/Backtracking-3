import java.util.*;
public class NQueens {
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        m = n;
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board,0);
        return result;
    }

    private void backtrack(boolean[][] board,int row){
        //base
        if(row==m){
            List<String> config = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j]){
                        temp.append('Q');
                    }
                    else{
                        temp.append(".");
                    }
                }
                config.add(temp.toString());
            }
            result.add(config);
        }
        //logic
        for(int col=0;col<m;col++){
            if(isSafe(board,row,col)){
                //action
                board[row][col] = true;
                //recurse
                backtrack(board,row+1);
                //backtrack
                board[row][col] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board,int row,int col){
        //same col
        for(int i=0;i<row;i++){
            if(board[i][col]) return false;
        }
        //upper left diagonal
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }

        //upper right
        i=row;
        j=col;
        while(i>=0 && j<m){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}
