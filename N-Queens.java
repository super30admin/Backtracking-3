//Problem : 74 - N-Queens
// Time Complexity : N!, because for each row available options are n->n-2->n-4.....like that factorial kind of thing
// Space Complexity : O(N*N),new board matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/* Place Queen in first row, then check whether it can be placed in all other rows. If it can be placed then add it to the result otherwise backtrack and keep changing Queen column position.
Here for validating Queen Position write for loop for check Queen position columnar wise, up diagonal left and up diagonal right. Always check for these position from 0 to previous row.

DFS for each row along with placement for Queen column wise
   
*/

import java.util.*;

class Solution {
    List<List<String>> res;
    int[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        //TC: N! | SC:N*N-> board matrix
        res = new ArrayList<>();
        
        if(n==0) return res;
        
        board = new int[n][n];
        m = n;
        
        helper(0);
        
        return res;
    }
    
    //heper for placing Queens
    private void helper(int r){
        
        //base
        if(r==m){
           
            List<String> li = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        
        //logic
        //columnar--> itearte over column
        for(int j=0;j<m;j++){
            if(isSafe(r,j)){
                
                board[r][j] = 1; //action
                
                helper(r+1); //recursion //next row
                
                board[r][j] = 0; //backtrack
            }
        }
        
    }
    
    private boolean isSafe(int r, int c){
        
        //check above columns
        for(int i=0;i<r;i++){//checking columns above given row
            if(board[i][c]==1) return false;
        }
        
        //check diagonal left;
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--;
            j--;
        }
        
        //check diagonal right row and column;
        i=r;
        j=c;
        while(i>=0 && j<m){
            if(board[i][j]==1) return false;
            i--;
            j++;
        }
        
        return true;
    }
    
    
}