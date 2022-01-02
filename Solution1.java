import java.util.*;
// Time Complexity : O(n!) for first call we have n decisions
//at every next recursive step we have n-2 decisions , and recursion continues till we reach end of the board
// Space Complexity :O(n*n)+O(n)=O(n*n) board array+maximum calls in the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    boolean [][]board;
     List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        board= new boolean[n][n];
        result= new ArrayList<>();
        //start at placing the queen in row 0
        backtrack(0);
        
        return result;
    }
    private void backtrack(int row){
        
        //base
        if(row==board.length){
            //if placed all teh queens in all the ros then we need to capture the board state
            List<String>outcome=new ArrayList<>();
            for(int i=0;i<board.length;i++){
            StringBuilder res= new StringBuilder();
            for(int j=0;j<board.length;j++){
                if(board[i][j]==true)
                    res.append("Q");
                else
                    res.append(".");
            }
            outcome.add(res.toString());
        }
            result.add(outcome);
            return;
        }
            
        
        //logic
        for(int j=0;j<board.length;j++){
            if(isSafe(row,j)){
                board[row][j]=true;
                backtrack(row+1);
                board[row][j]=false;
            }
        }
    }
        private boolean isSafe(int r, int c){
            
            //column check
            for(int i=r;i>=0;i--){
                if(board[i][c]==true)
                    return false;
            }
            
            // upper left diagonal check
            int i=r;
            int j=c;
            while(i>=0 && j>=0)
            {
                if(board[i][j]==true){
                    return false;
                }
                i--;
                j--;
            }
            
            // upper right diagonal check
             i=r;
             j=c;
            while(i>=0 && j<board.length)
            {
                if(board[i][j]==true){
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
    }