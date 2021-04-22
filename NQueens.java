// Time Complexity : O(N!) Since once we place a queen we wont have more than (N-2) possibilities for next. 
// Space Complexity : O(N) Where N is the number of rows. To store the values and call stack size.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We can solve this problem by using backtracking. In this approach we check for all the possible combinations of queen positions where each queen does not attach the other. In order to keep track of the blocked cells by the existing queen we keep 3 hash set where we have one for storing the blocked column(col), upper left diagnol(row-col) and upper right diagnol(row + col). Also to keep track of the queen placed in each row, we have an array with number of rows which can hold the column value for the queen placed in that row, this can be used to build the result list. We use backtraking so that once check one the possible solution by placing the queen in one location, we come back and modify the position of the queen to check for the other locations, so we have to remove the respective values from the set and check for the new position.

class Solution {
    int[] rowCol;
    int n;
    Set<Integer> colSet;
    Set<Integer> upperLeft;
    Set<Integer> upperRight;
    List<List<String>> result;
        
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n<1) return result; 
        
        this.n=n;
        // O(N)
        rowCol = new int[n];
        colSet = new HashSet<>();
        upperLeft = new HashSet<>();
        upperRight = new HashSet<>();
        
        backtracking(0);
        return result;
    }
    
    // O(1)
    private boolean isSafe(int row, int col){
        if(colSet.contains(col) || upperLeft.contains((row-col)) || upperRight.contains(row+col)) return false;
        return true;
    }
    
    // O(1)
    private void updateSet(int row, int col){
        colSet.add(col);
        upperLeft.add((row-col));
        upperRight.add((col+row));
        rowCol[row] = col;
    }
    
    // O(1)
    private void resetSet(int row, int col){
        colSet.remove(col);
        upperLeft.remove((row-col));
        upperRight.remove((col+row));
        rowCol[row] = -1;
    }
    
    // O(N^2)
    private void generateResult(){
        List<String> currentResult = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==rowCol[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            currentResult.add(sb.toString());
        }
        result.add(currentResult);
    }
    
    // O(N!)
    private void backtracking(int row){
        //base 
        if(row==n){
            generateResult();
            return;
        }

        //logic
        for(int col=0;col<n;col++){
            if(isSafe(row, col)){
                updateSet(row, col);
                backtracking(row+1);
                resetSet(row, col);  
            }   
        }   
    }
}
