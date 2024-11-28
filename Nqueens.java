// Approach : Using DFS Backtrack
// Time : O(n!) exponential # at each row n, n-2, n-4, n-6 ....
// Space : O(nXn) + O(n) recursion space
class Solution {
    List<List<String>> result;
    int m;
    int[][] board; // board  we need to show distinct boards with q's placements.
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new int[n][n];
        this.m =n;
        dfs(0); // call DFS backtrack on zeroth row
        return result;  
    }

    public void dfs(int r){
        // base case - placed successfully all the queens
        if(r==m){
            List<String> list = new ArrayList<>();
            // go through the entire board
            for(int i=0;i<m;i++){
                StringBuilder sp = new StringBuilder(); // at each row 
                for(int j =0;j<m;j++){
                    if(board[i][j] == 1){
                        sp.append("Q");
                    }else{
                        sp.append(".");
                    }
                }
                list.add(sp.toString());
            }
            result.add(list);
            return;
        }
        // logic
        // 1. Go through that particular row (r) and try to place the queen
        // so column will be incrementing
        for(int i=0;i<m;i++){
            // while placing queen - check if it is safe or not
            if(isSafe(r,i)){
                // action
                board[r][i] = 1;
                // recursion
                dfs(r+1);
                // backtrack
                board[r][i] = 0;
            }
        }
    }

    public boolean isSafe(int r , int c){
        // check only the three dirs - diagonal(up left,up right) and top same column;

        // case 1 : top same coulmn
        for(int i = 0; i<=r;i++){
            if(board[i][c] == 1){
                return false;
            }
        }

        // case 2 : diagonal up right
        int i = r-1; int j = c+1;
        // keep going up ..up ..
        while(i>=0 && j<m){
            if(board[i][j]==1){
                return false;
            } else{
                i--;
                j++;
            }
        }

        // case 3: diagonal up left
        i = r-1; j = c-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }else{
                i--;
                j--;
            }
        }

        return true;
    }
}