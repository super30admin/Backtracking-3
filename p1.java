// Time Complexity : O(n * (n!)) 
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//For loop based recursion
class Solution {

    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        //Matrix to keep track of queens
        int[][] mat = new int[n][n];
        helper(mat,0, n);
        return result;
    }

    private void helper(int[][] mat, int i, int n){
        //base
        //If we reach to the end of the board by placing queens in each row, put the board in the result
        if(i == n){
            List<String> list = new ArrayList<>();
            for(int k = 0; k<n; k++){
                StringBuilder sb = new StringBuilder();
                for(int l = 0; l<n; l++){
                    if(mat[k][l] == 0){
                        sb.append(".");
                    }
                    else{
                        sb.append("Q");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            
        }

        //recurse
        //Iterate through all the columns in each row
        for(int j = 0; j< n; j++){
            //Check whether it's safe to put the queen
            if(safe(mat, i, j, n)){
                //Action
                mat[i][j] = 1;
                //Recurse
                helper(mat, i+1, n);
                //Backtrack
                mat[i][j] = 0;
            }
        }
    }

    private Boolean safe(int[][] mat, int i, int j, int n){
        int k = i-1;
        int l = j;

        //Check whether the column is clear
        while(k>=0){
            
            if(mat[k][l] == 1){
                return false;
            }
            k--;
        }

        k = i-1;
        l = j-1;

        //Check whether the left diagonal is clear
        while(k>=0 && l>=0){
            
            if(mat[k][l] == 1){
                return false;
            }
            k--;
            l--;
        }

        k = i-1;
        l = j+1;

        //Check whether the right diagonal is clear
        while(k>=0 && l<n){
            
            if(mat[k][l] == 1){
                return false;
            }
            k--;
            l++;
        }

        return true;
    }
}