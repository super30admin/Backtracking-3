// Time Complexity : O(N!) // or O(N POW N).
// Space Complexity :O(N POW 2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. DP for loop with backtracking 
 * 2. Recursion loops through rows and for loops through columns.
 * 3. when ever you completed the last row add the result to the result list. 
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	 List<List<String>> result;
	    public List<List<String>> solveNQueens(int n) {
	        result= new ArrayList<>();
	        boolean[][] resultArr= new boolean[n][n];
	        helper(0,resultArr,n);
	        return result;
	    }
	    
	    private void helper(int row,boolean[][] resultArr,int n){
	        //base
	        if(row==n){
	            List<String> subres= new ArrayList<>();
	            for(int i=0;i<n;i++){
	                StringBuilder sb= new StringBuilder();
	                for(int col=0;col<n;col++){
	                    if(resultArr[i][col])
	                        sb.append("Q");
	                    else
	                        sb.append(".");
	                }
	                subres.add(sb.toString());
	            }
	            result.add(subres);
	            return;
	        }
	        //logic
	        for(int col=0;col<n;col++){
	            if(isvalid(row,col,resultArr,n)){
	                //action
	            resultArr[row][col]=true;
	            //recur
	            helper(row+1,resultArr,n);
	            //backtrack
	            resultArr[row][col]=false;    
	            }
	            
	        }
	        
	    }
	    private boolean isvalid(int row,int col,boolean[][] resultArr,int n){
	        //validate col
	        for(int j=0;j<row;j++){
	            if(resultArr[j][col]) return false;
	        }
	        //validate top left diag
	        int i=row-1;
	        int j=col-1;
	        while(i>=0&&j>=0){
	            if(resultArr[i][j]) return false;
	            i--;
	            j--;
	        }
	        
	        //validate top right dia
	         i=row-1;
	         j=col+1;
	        while(i>=0&&j<n){
	            if(resultArr[i][j]) return false;
	            i--;
	            j++;
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
			new NQueens().solveNQueens(4);
		}
}
