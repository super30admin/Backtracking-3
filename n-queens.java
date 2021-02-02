// Time Complexity : O(n!)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //create a matrix to represent the chess board
    int [][] board;
    //row and col variable
    int m;
    //return list
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        //set m = n beacues it is square matrix
        m = n;
        //initialize the size of the board
        board = new int[n][n];
        //call the helper function to find n queens which takes row as the parameter
        helper(0);
        return res;
    }
    
    private void helper(int row){
        //base
        //boundary
        if(row == m){
            //create a temp list to stort adding the queens and dots to master list
            List<String> temp = new ArrayList<>();
            //start iterating through the board to find 1's which represent queens and 0's which represent dots
            for(int i = 0; i < m; i++){
                //create the string that will hold the queens and dots
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < m; j++){
                    //if it equals a one it is a queen append to the list
                    if(board[i][j] == 1) {
                        s.append('Q');
                    }
                    //else it is a dot
                    else{
                      s.append('.');  
                    } 
                }
                temp.add(s.toString());
            }
            //now add the temp list to the master list
            res.add(temp);
            return;
        }
        
        //logic
        //iterate through the to check if a queen can be placed
        for(int j = 0; j < m; j++){
            //check if it is okay to place a queen here
            if(check(row,j)){
                //action
                board[row][j] = 1;
                //recurese
                helper(row+1);
                //backtrack
                board[row][j] = 0;
            }
        }
    }
    
    private boolean check(int r, int c){
        //up col
        for(int k = 0; k < r; k++){
            if(board[k][c] == 1) return false;
        }
        //diagonal left
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--; j--;
        }
        //diagonal right
        i = r;  j = c;
        while(i >= 0 && j < m){
            if(board[i][j] == 1) return false;
            i--; j++;
        }
        return true;
    }
}
