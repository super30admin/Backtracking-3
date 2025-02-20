import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n!)
// Space Complexity: O(n)

public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        int[][] board = new int[n][n];
        placeQueens(n,0, board);
        return result;
    }

    public boolean placeQueens(int n, int row, int[][] board){

        if(row == n){
            List<String> sl = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder("");
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                sl.add(sb.toString());
            }
            result.add(sl);
            return false;
        }

        for(int col=0;col<n;col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 1;
                if(placeQueens(n, row+1, board)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int row, int col, int[][] board, int n){
        for(int r=0;r<n;r++){
            if(board[r][col] == 1){
                return false;
            }
        }

        int i =row-1, j= col+1;
        while(i>=0 && j < n ){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }

        int m =row-1, num= col-1;
        while(m>=0 && num >= 0){
            if(board[m][num] == 1){
                return false;
            }
            m--;
            num--;
        }
        return true;
    }
}
