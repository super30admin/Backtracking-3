class Solution {
    
// Time Complexity : O(n ^ (n,2))  n: chess board size
// Space Complexity : O(n)  recursion stack -->backtrack function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Follow row wise filling of queen
 2. Avoid placing queen in same row --> backtrack function
 3. Avoid placing queen in same and diagonal position (both ways) --> isSafe function
 4. BackTrack to before row if all columns are visited but all queens are not placed yet.
 */
    
        List<List<String>> result;
        int[][] board;      //Board creation
        int m;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0) return result;
        board = new int[n][n];
        m = n;
        backtrack(0);         //start with first row
        return result;
    }
    
    private void backtrack(int i){
        if(i==m){              //when all rows visited --> all queens are placed at each row
            List<String> l = new ArrayList<String>();
            for(int r=0;r<m;r++){
                StringBuilder sb = new StringBuilder();
                for(int c =0;c<m;c++){
                    if(board[r][c]==1){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            result.add(l);
        }
        
        for(int j =0;j<m;j++){
            if(isSafe(i,j)){
                board[i][j] =1;      //assign    --> valid
                backtrack(i+1);      //recurse   --> next row
                board[i][j] =0;      //backtrack --> not working for next row, so make it invalid
            }
        }
        return;                 //when all columns are visited
    }
    
    private boolean isSafe(int i, int j){
        for(int k=0;k<m;k++){                     // up --> checking the all rows above under same column 
            if(board[k][j]==1) return false;
        }
        int r=i-1;int c=j-1;                      //upper left
        while(r>=0 && c>=0){
            if(board[r][c]==1) return false;
            r--;c--;
        }
        r=i-1;c=j+1;
        while(r>=0 && c<m){                      //upper right
            if(board[r][c]==1) return false;
            r--;c++;
        }
        return true;
    }
}