// Time Comlpexity: O(n^2)
// Space Complexity: O(n*n)

class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n==0) return res;
        boolean [][]board = new boolean[n][n];
        backtrack(board,0,n);
        return res;
    }
    
    private void backtrack(boolean [][]board, int r, int n){
        if(r==n){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        return;
        }
       
        for(int j=0;j<n;j++){
            if(isSafe(board,r,j,n)){
                board[r][j]=true;
                backtrack(board,r+1,n);
                 board[r][j]=false;
            }
        }
    }
    private boolean isSafe(boolean [][]board, int r, int c, int n){
        for(int i=0;i<r;i++){
            if(board[i][c]) return false;
        }
            int i=r;int j=c;
            while(i>=0 && j>=0){
                if(board[i][j]) return false;
                i--;
                j--;
            }
            i=r;j=c;
            while(i>=0 && j <n){
                  if(board[i][j]) return false;
                i--;
                j++;
            }
            
        
        return true;
    }
}
