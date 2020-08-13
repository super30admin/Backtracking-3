/*
// Time Complexity : O(n!)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/
class Solution {
    List<List<String>> ret;
    boolean[][] brd;

    public List<List<String>> solveNQueens(int n) {
        this.ret = new ArrayList<>();
        this.brd = new boolean[n][n];
        helper(n, 0);
        return this.ret;
    }

    private void helper(int n, int q){
        if(q >= n){
            addSolution();
            return;
        }
        for(int i = 0; i < brd[0].length; i++){
            //place quene. if col above and diagnoal does not contain
            //a queen.
            if(isValid(q,i)){
                brd[q][i] = true;
                helper(n,q+1);
                brd[q][i] = false;
            }
        }
    }

    //we can just check col above and both diagnols above this pos.
    //since no queen is below this loc.
    //also we are only adding only 1 queen in this row, and revering it back
    //on backtrack, so no need to chk row either.
    private boolean isValid(int r, int c){
        //col above.
        int prevRow = r-1;
        int prevCol = c;

        while(prevRow >= 0){
            if(brd[prevRow--][prevCol])
                return false;
        }

        //diagnol1 above.
        prevRow = r-1;
        prevCol = c-1;
        while(prevRow >= 0 && prevCol >= 0){
            if(brd[prevRow--][prevCol--])
                return false;
        }

        //diagnol2 above.
        prevRow = r-1;
        prevCol = c+1;
        while(prevRow >= 0 && prevCol < brd[0].length){
            if(brd[prevRow--][prevCol++])
                return false;
        }

        return true;
    }

    private void addSolution(){
        List<String> temp = new ArrayList<>();
        for(int i = 0 ; i < brd.length; i++){
            StringBuilder sbtemp = new StringBuilder();
            for(int j = 0; j < brd[0].length; j++){
                if(brd[i][j])
                    sbtemp.append("Q");
                else
                    sbtemp.append(".");
            }
            temp.add(sbtemp.toString());
        }
        ret.add(temp);
    }
}
