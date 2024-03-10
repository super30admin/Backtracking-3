package week6.day3;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0,n);
        return result;
    }

    private void backtrack(int row, int n){
        //base
        if(row==n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        //logic
        for(int col=0;col<n;col++){
            if(isSafe(row, col,n)){
                board[row][col]=true;
                backtrack(row+1,n);
                board[row][col]=false;
            }
        }
    }

    private boolean isSafe(int row, int col, int n){
        //check column
        for(int i=0;i<row;i++){
            if(board[i][col])
                return false;
        }
        //check left diagonal
        int i = row;
        int j = col;
        while(i>=0 && j>=0){
            if(board[i][j])
                return false;
            i--;j--;
        }
        
        //check right diagonal
        i = row;
        j = col;
        while(i>=0 && j<n){
            if(board[i][j])
                return false;
            i--;j++;
        }
        return true;
    }
}
public class SolveNQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
