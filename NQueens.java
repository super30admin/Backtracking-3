
//Time Complexity:O(n!)
//Space Complexity:O(n^2)
import java.util.ArrayList;
import java.util.List;
public class NQueens {
    List<List<String>> result;
    int m; int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        m = n;
        backtrack(0);
        return result;
    }
    private void backtrack(int r){
        if(r == m){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i <m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m ;j++){
                    if(board[i][j] ==1)sb.append("Q");
                    else sb.append(".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
           return; 
        }
        for(int c = 0; c < m;c++){
            if(isSafe(r,c)){
                board[r][c] = 1;
                backtrack(r+1);
                board[r][c] =0;
            }
        }
    }
    private boolean isSafe(int r, int c){
        for(int i = 0; i < r;i++){
            if(board[i][c] == 1)return false;
        }
        //diagonals
        int i = r-1, j = c+1;
        while(i>= 0 && j < m){
            if(board[i][j] == 1)return false;
            i--;j++;
        }
        i = r-1; j = c-1;
        while(i>= 0 && j >= 0){
            if(board[i][j] == 1)return false;
            i--;j--;
        }
        return true;
    }
    public static void main(String args[]){
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));

    }
}