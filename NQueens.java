// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : check if queen can be placed at each cell of the board. Verify if a position is safe using isSafe function
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int cols[] = new int[n];
        List<List<String>> res = new ArrayList<>();
        helper(0, n, cols, res);
        return res;
    }
    public void helper(int idx, int n, int cols[], List<List<String>> res){
        if(idx==n){
            List<String> pos = new ArrayList<>();
            for(int i=0;i<cols.length;i++){
                String s = "";
                for(int j=0;j<n;j++){
                    if(j==cols[i]){
                        s+="Q";
                    }
                    else{
                        s+=".";
                    }
                }
                pos.add(s);
            }
            res.add(pos);
        }
        for(int i=0;i<n;i++){
            if(isSafe(idx, i, cols)){
                cols[idx] = i;
                helper(idx+1, n, cols, res);
            }
        }
    }
    private boolean isSafe(int r, int c, int cols[]){
        //checking if col is safe
        for(int i=0;i<r;i++){
            if(cols[i]==c){
                return false;
            }
        }
        //checking upper left diagonal
        int j = c-1;
        for(int i=r-1;i>=0;i--){
            if(j>=0 && cols[i]==j){
                return false;
            }
            j--;
        }
        //checking upper right diagonal
        j = c+1;
        for(int i=r-1;i>=0;i--){
            if(j<cols.length && cols[i]==j){
                return false;
            }
            j++;
        }
        return true;
    }
}