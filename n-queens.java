// Time Complexity :
O(n!) there are n possibilities to put the first queen, 
not more than n(n-2) to put the second one, 
not more than  n(n-2) n(n-4) for the third one etc. 
// Space Complexity :
O(n) 
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    //declare global result
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //base case
        if(n == 0) return result;
        //create a chessboard off n*n size
        char [][] grid = new char[n][n];
        //Fill all the values in the grid with '.'
        for(int m = 0;m<grid.length;m++){
            for(int k=0;k<grid[0].length;k++ ){
                grid[m][k] = '.';
            }
        }
        //call the helper function
        helper(grid,0,n);
        //return result
        return result;
        
    }
    //ind indicates which queen we are dealing with
    private void helper(char [][] grid, int ind, int n ){
        //base case when all the rows are traversed
    if(ind == grid.length){
        List<String> temp = helper(grid);
        result.add(new ArrayList<>(temp));
        return;
    }
    for(int i = 0; i < n;i++ ){
        if(isValid(grid,ind,i) == true){
            //set the grid value with Q
            grid[ind][i] = 'Q';
            //recurse through next positions
            helper(grid,ind + 1,n);
            //before the recursion returns to it's parent call reset the grid value
            grid[ind][i] = '.';
            
        }
        }
        
    }
    //The logic to create a list and add all the respective rows values of grid
    private List<String> helper(char [][] grid){
    List<String> list = new ArrayList<>();
        
    for(int x = 0; x<grid.length;x++){
        list.add(new String(grid[x]));
    }
    return list; 
}
    
    //Method to check if a position is valid or not
    private boolean isValid(char[][] grid,int ind, int i){
        //check horizontal
    for(int row=ind-1,col=i;row>=0;row--){
        if(grid[row][col] == 'Q'){
            return false; 
        }
    }
        //check if a queen can be placed in left diagonal
    for(int row=ind-1,col=i-1;row>=0 && col>=0;row--,col--){
        if(grid[row][col] == 'Q'){
            return false ;
        }
    }
        
         //check if a queen can be placed in right diagonal
    for(int row=ind-1,col=i+1;row>=0 && col<grid[0].length;row--,col++){
        if(grid[row][col] == 'Q'){
            return false ;
        }
    }
    return true; 
    
    }
    }