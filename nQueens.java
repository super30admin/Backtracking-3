// N Queens(https://leetcode.com/problems/n-queens/)

// Time Complexity : O(n!)
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, first create a boolean board of size nxn. Use helper function to recurse. To check if a queen can be placed in a particular
 * column, check for the rows above using isSafe function. If it is safe make board at particular row and column as true and 
 * recurse for next row. When row is equal to board.length, make a stringbuilder for each row with Q for trues and . for falses and
 * append to li for every row and finally add that to result. Finally, return result.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][]board = new boolean[n][n];
        helper(board, 0, result);
        return result;
    }
    private void helper(boolean [][]board, int r, List<List<String>> result){
        // base
        if(r == board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i< board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<board.length;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }

        //logic
        for(int c = 0; c<board.length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                helper(board, r+1, result);
                board[r][c] = false;
            }
        }
    }
    private boolean isSafe(boolean [][]board, int r, int c){
        // straight up if queen is already present result false
        for(int i = 0; i< r;i++){
            if(board[i][c]){
                return false;
            }
        }
        // diagonal left
        int i = r, j = c;
        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        // diagonal right
        i = r; j = c;
        while(i>=0 && j<board.length){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    } 
}