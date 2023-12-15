//Time Complexity:O(n*n!)for placing queens+O(n^2)for generating result string list  =>     O(n*n!)
//Space Complexity:O(n^2)
//Approach:Backtracking 
class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0,n);
        return result;
    }

    private void helper(int row, int n){
        //base case
        if(row==n){
            List<String> temp = new ArrayList<>();
            for(int i =0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j =0;j<n;j++){
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }

        //logic
        for(int j =0;j<n;j++){
            if(isSafe(row,j,n)){
                board[row][j]= true;
                helper(row+1,n);
                board[row][j]= false;
            }
                
            
        }
    }

    private boolean isSafe(int row, int col, int n){
        int r = row;
        int c = col;

        //row check
        while(r>=0){
            if(board[r][c]) return false;
            r--;
        }

        r = row;
        c = col;
        //diagonal check
        while(c>=0 && r>=0){
            if(board[r][c]) return false;
            c--; 
            r--;
        }

        r = row;
        c = col;
        //col check
        while(r>=0&&c<n){
            if(board[r][c]) return false;
            r--;
            c++;
        }
        return true;
    }
}