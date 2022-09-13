//TC : O(n!)
//SC : O(n^2)

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<List<String>>();
        if(n==0) return result;
        boolean[][] board = new boolean[n][n];
        helper(board,0,n);
        return result;
    }
    
    private void helper(boolean[][] board,int idx,int n){
        if(idx >= n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j])
                        str.append('Q');
                    else
                        str.append('.');
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(isSafe(board,idx,i,n)){
                board[idx][i] = true;
                helper(board,idx+1,n);
                board[idx][i] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board,int r,int c,int n){
        for(int i=0;i<r;i++){
            if(board[i][c])
                return false;
        }
        int i=r,j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;j--;
        }
        
        i=r;
        j=c;
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--;c++;
        }
        return true;
    }
}
