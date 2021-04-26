//Time Complexity: O(n!)
//Space Complexity:O(n^2)
class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board= new int[n][n];
        
        helper(board,n,0);// 0 here indicate row because we can place only 1 queen in a row at max
        return res;
    }
    private void helper(int[][]board, int n , int r){
        //base
        if(r==n){
            List<String> sol= new ArrayList<>();
            for(int i=0;i<n;i++){
                String s ="";
                for(int j=0;j<n;j++){
                    int curr=board[i][j];
                    if(curr==1){
                        s=s+"Q";
                    }else s=s+".";
                }
                sol.add(s);
            }
            res.add(sol);
            return;
        }
        //logic
        for(int c=0;c<n;c++){
            if(isSafe(board,r,c, n)){
                //action
                board[r][c]=1;
                //recurse
                helper(board, n, r+1);
                //backtrack
                board[r][c]=0;
            }
        }
    }
    private boolean isSafe(int[][] board, int r,int c, int n){
        
        //upper coloums
        for(int i=0;i<n;i++){
            if(board[i][c]==1) return false;
        }
        //upper left diagonol
        int i=r-1,j=c-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--;
            j--;
        }
        //upper right diagonal
        i=r-1;
        j=c+1;
        while(i>=0 && j<n){
            if(board[i][j]==1) return false;
            i--;
            j++;
        }return true;
    }
}