package Backtracking_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Using for loop based recursion here. For each row, we try to place the queen
 * at the col (as indicated by the loop variable) and go to the subsequent rows
 * and check if we can place remaining queens. If not possible we go back to the
 * prev row and move the queen to the next col and then try to solve for
 * remaining queens.
 * 
 * Time Complexity : O(n!)- where n is the given board dimension (as we go to
 * next row no of options to place queen reduces).
 * 
 * Space Complexity : O(n), actually is for recursive stack space.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem1 {
    List<List<String>> res= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean arr[][]= new boolean[n][n];
        helper(arr,0,0);
        return res;
    }

    void helper(boolean arr[][], int row, int queensPlaced){
        //base
        if(row==arr.length && queensPlaced==arr.length){
            List<String> sol= new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                StringBuilder string = new StringBuilder();
                for(int j=0;j<arr[0].length;j++){
                    if(arr[i][j]==false){
                        string.append(".");
                    }
                    else
                        string.append("Q");
                }
                 sol.add(string.toString());
            }
            res.add(sol);
            return;
        }

        //logic
            for(int j=0;j<arr[0].length;j++){
               if(isSafe(arr,row,j)) {
                    arr[row][j]=true;
                    queensPlaced++;
                    helper(arr,row+1, queensPlaced);
                    arr[row][j]=false;
                    queensPlaced--;

                }
            
    }}

    boolean isSafe(boolean arr[][], int i, int j){
        int tempI=i;
        int tempJ=j;
        //diagonalLeft
        while(i>=0 && j>=0){
            if(arr[i][j]==true)
                return false;
            
            i--;
            j--;
        }

         i=tempI;
         j=tempJ;
        //diagonalRight
        while(i>=0 && j<arr[0].length){
            if(arr[i][j]==true)
                return false;
            
            i--;
            j++;
        }

         i=tempI;
         j=tempJ;
        //checkCol
         while(i>=0){
            if(arr[i][j]==true)
                return false;
            
            i--;
        }
        return true;
    }

}
