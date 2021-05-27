// Time Complexity :O(n!), n=number of queens
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class NQueens {

    //list to store result
    List<List<String>> result;
    //matrix to store postion of queens
    int[][] board;

    public List<List<String>> solveNQueens(int n) {
        //initializing list
        result = new ArrayList<>();
        //initializing board matrix
        board = new int[n][n];
        //calling method to find location of queens
        backtrack(0,n);
        return result;
    }

    //method to find location of queens
    public void backtrack(int r, int n){

        //base
        //row count is equal to number of queen
        if(r==n){
            //list to store position of queen in all rows
            List<String> li = new ArrayList<>();
            //looping though all rows
            for(int i=0; i<n; i++){
                //string variable to store psotion of queent in current row
                StringBuilder sb = new StringBuilder();
                //looping through all columns
                for(int j=0; j<n; j++){
                    //if queen found at current position
                    if(board[i][j]==1){
                        sb.append("Q");
                    }//if no queen found
                    else{
                        sb.append(".");
                    }
                }
                //update list with postion of queen for current row
                li.add(sb.toString());

            }//update result with postion of queen for all rows
            result.add(li);
            return;
        }
        //logic
        //looping through the columns
        for(int c=0; c<n; c++){
            //if current position is safe for queen
            if(isSafe(r,c, n)){
                //mark postion as queen
                board[r][c] = 1;
                //recurse to next row
                backtrack(r+1, n);
                //backtrack
                //undo the previous change
                board[r][c] = 0;
            }
        }

    }
    //method to check if current position is safe for queen
    public boolean isSafe(int r, int c, int n){

        //above the same column
        for(int i=0; i<r; i++){
            if(board[i][c]==1){
                return false;
            }
        }

        int i=r, j=c;
        //diagonal on up right
        while(i>=0 && j<n){
            if(board[i][j]==1) return false;
            i--; j++;
        }

        i=r;
        j=c;
        //diagonal on up left
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--; j--;
        }

        return true;
    }
}