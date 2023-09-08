//TC: n*(n-1)*(n-2)*(n-3)... = O(n!) 
//SC: O(N^2)+O(N) //backtracking board + recursion stack

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n]; 
        helper(board,n,0);
        return result;
        
    }

    private void helper (boolean[][] board, int n , int r){
        //base
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                li.add(sb.toString());
            }
            result.add(li);
        }

        //logic
        for (int c=0;c<n;c++){
           
            if(checkPlace(n,r,c,board)){
                 //action
                board[r][c] = true;
                //recursion
                helper(board,n,r+1);
                //backtrack
                board[r][c]=false;
            }
            
        }
        
    }

    private boolean checkPlace(int n ,int r , int c, boolean[][]board){
        //column
        for (int l=0;l<r ; l++){
                if(board[l][c]==true) return false;
        }

        //left diagonal
        int i=r;
        int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==true) return false;
            i--;
            j--;
        }
        //right diagonal
        i=r;
        j=c;
        while(i>=0 && j<n){
            if(board[i][j]==true) return false;
            i--;
            j++;
        }

        return true;

    }
}