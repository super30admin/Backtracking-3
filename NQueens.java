// Time Complexity : O(n^n/2)
// Space Complexity : O(n*No.ofValidSolns*m) m : Stringbuilder for each row
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    List<List<String>> result; //result list of list
    int m; //size of board to use in backtrack method
    int board[][]; //size of N*N board
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>(); //initialize the result
        m = n; //set m = n
        board = new int[m][m]; //initialize size of board
        backtrack(0); //call backtrack method for row = 0
        return result; //return the result list
    }
    
    
    private void backtrack(int r) {
         //(no. of rows in board = m-1) if r==m, we have placed queen in all m-1 rows 
        if(r == m) {
            //create templist to add to result (templist has m stringbuilders -one for eachrow)
            List<String> tempList = new ArrayList<>();
            //for each row in board
            for(int i = 0; i < m; i++) {
                //each row is a stringbuilder ("q" and ".")
                StringBuilder rowString = new StringBuilder();
                //for each col of each row 
                //if = 0, append .
                //if = 1 (Q) append Q
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == 0) {
                        rowString.append('.');
                    }
                    else {
                        rowString.append('Q');
                    }
                } tempList.add(rowString.toString()); //add stringbuilder to templist
            } result.add(tempList); //add templist to result
            return; 
        }
        
        //logic
        for(int i = 0; i < m; i++) {
            //check if for row r, ith col is safe to place the Q
            if(isSafe(r,i)) {
                //if safe, make the board value 1
                board[r][i] = 1;
                //call method for next row
                backtrack(r+1);
                //backtracking : make the last placed Q back to "." (1 to 0)
                board[r][i] = 0;
            }
        }        
    }   
  
    //check for safe position for row and col
    //it is safe if no Q in same row 
    // no Q in same Col
    //no Q diagonally
    private boolean isSafe(int row, int col) {
        //for the col
        //interate till row value for that col value, if = 1, return false
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 1) return false;
        }
        
        //left diagonal
        //i = row - 1 and j = col -1
        int i = row-1;
        int j = col-1;
        //till i or j = 0 (index out of bound)
        while( i >= 0 && j >= 0) {
            //if any cell = 1, return false
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        
        //right diagonal
        //i = row - 1 and j = col+1
        i = row-1;
        j = col+1;
        //till i = 0 or j = m-1 (index out of bound)
        while( i >= 0 && j < m) {
            //if any cell = 1, return false
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        //if no condition returns false, then position is safe, return true
        return true; 
    }
}


