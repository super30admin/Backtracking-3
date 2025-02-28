// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Backtracking
 */

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        backtrack(board,0);
        return result;
    }

    private void backtrack(boolean[][] board,int r){
        // base
        if(r==board.length){
            List<String> li=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }

        //logic
        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                backtrack(board,r+1);
                board[r][c]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board,int r,int c){
        // up
        for(int i=0;i<r;i++){
            if(board[i][c]) return false;
        }

        // top left
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }

        // top right
        i=r;
        j=c;
        while(i>=0 && j<board.length){
            if(board[i][j]) return false;
            i--;
            j++;
        }

        return true;
    }
}
