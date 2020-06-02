package s30Coding;
import java.util.*;

//Time Complexity :- O(N!)
//Space Complexity :- O(N)

//LeetCode :- yes

public class NQueens {
	int [][] board;
    List<List<String>> result;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new int[n][n];
            placeQueens(0);
        return result;
    }
    private void placeQueens(int r ){
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < m ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m ; j++){
                    if(board[i][j] == 0){
                        sb.append('.');
                    }
                    else{
                        sb.append('Q');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        for(int i = 0; i < m ; i++){
            if(isSafe(r, i)){
                 board[r][i]  = 1;
            placeQueens(r+1);
                board[r][i] = 0;
            }
           
        }
    }
    private boolean isSafe(int r , int c){
        for(int k = 0; k <= r; k++){
            if(board[k][c] == 1) return false;
        }
        
        int i = r-1; int j = c+1;
         while(i >=0 && j < m){
             if(board[i][j] == 1) return false;
             i--;j++;
         }   
        i = r -1; j = c-1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        return true;
    }
}
