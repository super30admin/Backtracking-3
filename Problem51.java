package problems.backtrack;

import java.util.ArrayList;
import java.util.List;
//Time Complexity - O(n!)
//Space Complexity - O(n*n) - board
public class Problem51 {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        backtrack(board,0);
        return result;
    }
    private void populateResult(boolean[][] board){
        List<String> subList=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<board.length;j++){
                if(board[i][j])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            subList.add(sb.toString());
        }
        result.add(subList);
    }

    private void backtrack(boolean[][] board, int idx){
        //base case
        if(idx== board.length) //we have placed all queens in result
            populateResult(board);

        //logic
        //we will only travel columns as we need to place only 1 queen in each row
        for(int j=0;j<board.length;j++){
            if(isSafe(board,idx,j)){
                board[idx][j]=true;
                backtrack(board,idx+1);
                board[idx][j]=false;
            }
        }
    }
    private boolean isSafe(boolean[][] board, int r, int c){
        //we will need to check the if the location is safe in 3 directions
        //up - we will check it from 0 th position to current column
        for(int i=0;i<r;i++){
            if(board[i][c])
                return false; // we will return unsafe whenever we encounter already place queen in same column
        }
        //diagonal up right where column index will increase and row will decrease
        //we cant mutate r and c as we will need it in chk diag up left
        int i=r;
        int j=c;
        while(i>=0 && j<board.length){
            if(board[i][j])
                return false; // we will return unsafe whenever we encounter already place queen in diagonal up right column
        i--;
        j++;
        }

        //diagonal up right where column index will increase and row will decrease
        i=r;
        j=c;
        while(i>=0 && j>=0){
            if(board[i][j])
                return false; // we will return unsafe whenever we encounter already place queen in diagonal up right column
        i--;
        j--;
        }
        return true;
    }


    public static void main(String[] args) {
        Problem51 problem=new Problem51();
        System.out.println(problem.solveNQueens(4));
        System.out.println(problem.solveNQueens(2));
    }
}
