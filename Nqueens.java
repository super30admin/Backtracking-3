package Fifth_week.longest_word_dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {
    List<List<String>> result;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        m=n;
        backTrack(0);
        return result;
    }

    public void backTrack(int r){

        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    } else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }


        //logic
        for(int j=0;j<m;j++){
            if(isSafe(r,j)){
                board[r][j] = 1;
                backTrack(r+1);
                board[r][j] = 0;
            }
        }
    }

    private boolean isSafe(int r,int c){
        //Column up
        for(int k = 0;k<r;k++){
            if(board[k][c] == 1) return false;
        }

        //column up left
        int i=r;int j =c;
        while(i >=0 && j >=0){
            if(board[i][j] ==1){
                return false;
            }
            i--;j--;
        }

        // colum up right
        i =r;j=c;
        while(i>=0 && j<m){
            if(board[i][j]==1){
                return false;
            }
            i--;j++;
        }
        return true;
    }


    public static void main(String[] args) {
        int n =4;
        Nqueens q = new Nqueens();
        List<List<String>> result = q.solveNQueens(n);

        for(List<String> li : result){
            System.out.println(li.toString());
        }
    }

}
