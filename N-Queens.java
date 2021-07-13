// Time Complexity: O(N!)
// Space Complexity: O(N)
// Run on leetcode: yes
// Issues faced: Could not come up with the solution on my own had to go back and watch the video again.
class Solution {
    int[][] board;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.board = new int[n][n];
        this.res = new ArrayList<>();
        backtrack(n, 0);
        return res;
    }
    
    public void backtrack(int n, int row){
        if(row == n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder str = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1)
                        str.append('Q');
                    else
                        str.append('.');
                }
                li.add(str.toString());
            }
            res.add(li);
        }
        for(int col=0; col<n; col++){
            if(isSafe(row, col, n)){
                board[row][col] = 1;
                backtrack(n, row+1);
                board[row][col] = 0;
            }
        }
    }
    
    public boolean isSafe(int r, int c, int n){
        // check for queen in the same column
        for(int i=0; i<r; i++){
            if(board[i][c] == 1)
                return false;
        }
        
        // check for queen diagonally up left
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        
        // check for queen diagonally up right
        i=r;
        j=c;
        while(i>=0 && j<n){
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        
        return true;
    }
}
