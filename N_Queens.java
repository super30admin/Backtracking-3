// 51. N-Queens - https://leetcode.com/problems/n-queens/
// Time Complexity - exponential
// Space Complexity - O(1)
// Did it run on leetcode? Yes
// Any problems? No

class Solution {
    List<List<String>> result;
    boolean[][] board; 
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        if(n == 2 || n == 3) return result;
        
        board = new boolean[n][n];
        helper(n,0);
        return result;
    }
    
    private void helper(int n , int row){
        // base
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i <n; i++){
                StringBuilder sb =  new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        // logic
        for(int i = 0; i<n; i++){
            if(isSafe(row, i, n)){
                board[row][i] = true;  // action
                helper(n, row+1);      // recurse
                board[row][i] = false; // backtrack
            }
        }
    }
    
    private boolean isSafe(int r, int c, int n){
        // column
        for(int j =0; j<r; j++){
            if(board[j][c]) return false;
        }
        // diagonal left
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        // diagonal right
        i =r; j=c;
        while(i>=0 && j<n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }
}