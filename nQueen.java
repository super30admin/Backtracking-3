// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//Use backtrack to explore all the above options. Check if the above cols are valid or not.
//We need to check for both the diagonals and the vertical validity.
//If valid, then add the col number.

class Solution {
    public List<List<String>> solveNQueens(int n) {
       
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        
        backtrack(solution, state, n, 0);
        
        List<List<String>> result = new ArrayList<>();
       
        
        for(List<Integer> res: solution){
             List<String> current = new ArrayList<>();
            System.out.println(res);
            for(int j=0; j<res.size(); j++){
                StringBuilder sb = new StringBuilder(n);
                
                for(int i=0; i<res.get(j); i++){
                        sb.append(".");  
                        System.out.println("value of i: " + i);
                    }
                    sb.append("Q");
            
                for(int i=res.get(j)+1; i<n; i++){
                        sb.append(".");                   
                }
                current.add(sb.toString());
                System.out.println(current); 
            }
             result.add(new ArrayList<>(current));           
        }
        
        return result;
        
    }
    
    private void backtrack(List<List<Integer>> solution, List<Integer> state, int n, int row){
        
        //whenever row hits the total number n, add and return
        if(row == n){
            solution.add(new ArrayList<>(state));
            return;
        }
        
        //iterate over the cols
        for(int j=0; j<n; j++){
            //check whether we can place the queen at that particular col or not
            if(canPlace(state, n, row, j)){
                //if yes, then add to the state
                state.add(j);
                //call recursively
                backtrack(solution, state, n, row+1);
                //remove the state
                state.remove(state.size() - 1);
            }
        }
        
    }
    
    private boolean canPlace(List<Integer> state, int n, int row, int col){
        //we are always checking the upper rows and cols
        return diagonalValid(state, n, row, col) && verticalValid(state, n, row, col);
    }
    
    private boolean diagonalValid(List<Integer> state, int n, int row, int col){
        
        int i = row-1, j = col-1;
        
        while(i >= 0 && j >= 0){
            if(state.get(i) == j){
                return false;
            }
            i--;
            j--;
        }
        
        i = row-1; j = col+1;
        while(i >= 0 && j < n){
            if(state.get(i) == j){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
    
     private boolean verticalValid(List<Integer> state, int n, int row, int col){
        //start from the previous row
         int i = row -1;
         while(i >= 0){
             if(state.get(i) == col){
                 return false;
             }
             i--;
         }
         return true;         
    }
    
    
}