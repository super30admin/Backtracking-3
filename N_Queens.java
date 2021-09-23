// Time Complexity : O(n)*O((n-2)!) = O(n!) = We traverse row by row decreasing our choices by 2 each time(n-2)
// Space Complexity : O(n^2) + O(n) = O(n^2), n^2 is for creating board and O(n) is for recursive stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    boolean[][] board;
    List<List<String>> result; 
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0);
        return result;
    }
    private void helper(int r){
        if(r==board.length){
            List<String> li = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder s = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    if(board[i][j]==false)s.append('.');
                    else{
                        s.append('Q');
                    }
                }
                li.add(s.toString());
            }
            result.add(li);
        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(r,j)){
                board[r][j] = true;
                helper(r+1);
                //backtracking: Here, make board[r][j] as false, removing the earlier true case.
                //This itself is backtracking( Converting to False)
                //No reducing an array/queue size by 1 like other backtracking algorithms.
                board[r][j] = false;
            }  
        }
    }
    private boolean isSafe(int r, int c){
        //3cases:
        //Case1: Checking along a column
        int x=0;
        while(x<r){
            if(board[x][c]==true)return false;
            x++;
        }
        //Case2: Checking along upper left diagonal
        int i = r;
        int j = c;
        while(i>=0 && j>=0){
            if(board[i][j]==true)return false;
            i--;j--;
        }
        //Case3: Checking along upper right diagonal
        i=r;j=c;
        while(i>=0 && j<board.length){
            if(board[i][j]==true)return false;
            i--;j++;
        }
        return true;
    }
}