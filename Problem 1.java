// Time Complexity : O(n! * 3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach in three sentences only
/*
Will pick one column in each row and then place the next queen carefully

*/


class Solution {
    private List<List<String>> result;
    private boolean[][] grid;
    private boolean[] cols; // This array would mark the columns already taken
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        // we will use this grid to place value
        // we will put true where we place the queen
        grid = new boolean[n][n];
        cols = new boolean[n];

        for(int col =0;col<n;col++){ //O(n)
            // putting the queen at the col
            grid[0][col] = true; //action
            cols[col] = true;
            helper(1,n); //recurse
            grid[0][col] = false;//backtrack
            cols[col] = false;//backtrack
        }
        return result;
    }
    //helper function to iterate over the rows
    /*
    @param int row : next row index
    @param int n : number of queens/colums
    */
    private void helper(int row,int n){
        //base case
        // when row out of bounds
        if(row==n){
            // we will make a list of String and put in the result
            List<String> list = new ArrayList<String>();
            for(int r = 0;r<n;r++){
                StringBuilder stringRow = new StringBuilder();
                for(int c=0;c<n;c++){
                    if(grid[r][c]){
                        stringRow.append("Q");
                    }
                    else{
                        stringRow.append(".");
                    }
                    
                }

                list.add(stringRow.toString());                
            }

            result.add(list);

            return;
        }

        //logic
        for(int col=0;col<n;col++){
        if(isPossible(row,col)){ // 3n
            //action
            grid[row][col]= true;
            cols[col] = true;
            //recurse
            helper(row+1,n);
            //backtrack
            grid[row][col]= false;
            cols[col] = false;
        }
        }

    }
    
    //The function will check  if its feasible to put the next queen at this location
    private boolean isPossible(int row,int col){
        
        // do bounds check first
        if(row >=grid.length || row<0 || col<0 || col >= grid[0].length  ){
            return false;
        }
        //Check if col already taken
        if(cols[col]){
            return false;
        }


        /*
        // go up 
        for(int r=row;r>=0;r--){
            if(grid[r][col]){
                return false;
            }
        }
        */

        // we wont go down because we are geoing downwards so we only need to check for prev rows

        // upper left - diagonal
        for(int r=row,c= col; c>=0 && r>=0 ;r--,c--){ // O(n)
            if(grid[r][c]){
                return false;
            }

        }

        //upper right - diagonal
        for(int r=row,c= col; c<grid[0].length && r>=0 ;r--,c++){// O(n)
            if(grid[r][c]){
                return false;
            }
        }
        

        return true;

    }
}