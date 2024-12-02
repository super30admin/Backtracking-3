//51. N-Queens - https://leetcode.com/problems/n-queens/description/
//Time Complexity: O(n!)
//Space Complexity: O(m*n)

class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0, n);
        return result;
    }

    private void helper(int row, int n){
        //base case
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=-0; j<n; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //logic
        //we are in 0th row, go over every column
        //for all columns
        for(int j=0; j<n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j]=true;
                //recurse
                helper(row+1, n);
                //backtrack
                board[row][j]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int i, int j, int n){
        int r=i, c=j;
        //check all rows > 0
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }
        //diagonal left
        r=i; c=j;
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--; c--;
        }
        //diagonal right
        r=i; c=j;
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--; c++;
        }
        return true;
    }
}