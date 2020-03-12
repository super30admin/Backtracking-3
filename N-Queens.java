// Time Complexity : O(N!)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public List<List<String>> solveNQueens(int n) {
         List<List<Integer>> result =new LinkedList<>();
        List<Integer> state= new ArrayList<>();
        backtrack(result,state,n,0);
        System.out.println(result);
        return null;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> state,int n,int row){
        if(row == n){
            result.add(new LinkedList<>(state));
            return;
        }
        for(int i=0;i<n;i++){
            if(issafetoPlace(state,n,row,i)){
                state.add(i);
                backtrack(result,state,n,row+1);
                state.remove(state.size()-1);
            }
        }
    }
    private boolean issafetoPlace(List<Integer> state,int n,int row,int col){
       return diagonalcheck(state,n,row,col) &&  verticalcheck(state,n,row,col) ;
    }
    private boolean verticalcheck(List<Integer> state,int n,int row,int col){
       int i=row-1;
        while(i>=0){
            if(state.get(i)==col){return false;}
            i--;
        }
        return true;
    }
    private boolean diagonalcheck(List<Integer> state,int n,int row,int col){
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(state.get(i)==j){
                return false;
            }
        i--;
        j--;
        }
        
         int p=row-1;
        int q=col+1;
        while(p>=0 && q<n){
            if(state.get(p)==q){
                return false;
            }
        p--;
        q++;
        }
        return true;
    }
}