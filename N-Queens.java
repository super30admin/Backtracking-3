class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        this.board=new boolean[n][n];
        helper(0,n);
        return result;
        
    }
    
    private void helper(int i,int n){
        if(i==n){
            List<String> path=new ArrayList<>();
            for(int r=0;r<n;r++){
                StringBuilder sb=new StringBuilder();
                for(int c=0;c<n;c++){
                    if(board[r][c]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
            return ;
        }
        
        
        
        for(int j=0;j<n;j++){
            if(isSafe(i,j,n)){
                board[i][j]=true;
                helper(i+1,n);
                board[i][j]=false;
            }
        }
    }
    
    
    private boolean isSafe(int i,int j,int n){
        int r=i;
        int c=j;
        while(r>=0){
            if(board[r][c]) return false;
            r--;
        }
        
        r=i;c=j;
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--; c--;
        }
        r=i;c=j;
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--;c++;
        }
        return true;
    }
    
}