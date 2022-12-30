import java.util.*;

//Time Complexity: O(n!) // at each level we decrease the number of choices we have for queens
//Space Complexity: O(n^2) //the board is the only extra space

/*
 * in the first row we check for each column where can the next queen be placed on the board.
 * when we reach the end of the rows we add the row to the output.
 */

class Solution {
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    public void helper(int r, int n){
        //base
        if(r == n){
            List<String> li = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{ // board is false 
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        //logic
        for(int i = 0; i < n; i++){
            if(isSafe(r, i, n)){
                //action
                board[r][i] = true;
                //recurse
                helper(r+1, n);
                //backtrack
                board[r][i] = false;
            }
        }
    }

    public boolean isSafe(int r, int c, int n){
        //up
        for(int i = 0; i < r; i++){
            if(board[i][c]) return false;
        }
        //right diagonal
        int i = r; int j = c;
        while(i>=0 && j < n){
            if(board[i][j]) return false;
            i--; j++;
        }

        //left diagonal
        i = r; j = c;
        while(i>=0 && j >= 0){
            if(board[i][j]) return false;
            i--; j--;
        }
        return true;
    } 
}