class Solution {
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        helper(0,n);
        return result;
        
    }

    private void helper(int r, int n){
        //base 
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }


        //logic 

        for(int j=0;j<n;j++){
            if(isSafe(r,j,n)){
                //action
                board[r][j] = true;

                //recurse
                helper(r+1, n);

                //backtrack
                board[r][j] = false;
            }
        }
    }


    private boolean isSafe(int r, int c, int n){
        //Column Up

        for(int i=0; i<r; i++){
            if(board[i][c]) return false;
        }

        //diagonal up right

        int i=r; int j=c;
        while(i>=0 && j<n){
            if(board[i][j]) return false;
            i--;j++;
        }

        i=r; j=c;
        //diagonal up right
        while(i >=0 && j>=0){
            if(board[i][j]) return false;
            i--;j--;
        }
        return true;
    }
}



/*
TC : O(N!)
SC : O(N*N!)

Description : 

Exploring all possible paths by doing backtracking. 
Here we are finding all possible ways to find n queens. 
TC : n factorial, exponential 


 */