class Solution {
    List<List<String>>res;
    public List<List<String>> solveNQueens(int n) {
        this.res=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        helper(board,0,n);
        return res;
    }
    private void helper(boolean[][] board,int row,int n){
        //base
        if(row==n){
            List<String>list=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==true){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int j=0;j<n;j++){
            if(isValid(board,row,j,n)){
                board[row][j]=true;
                helper(board,row+1,n);
                board[row][j]=false;
            }
        }  
    }
    private boolean isValid(boolean[][] board,int row,int col,int n){
        int r=row,c=col;
        while(r>=0){
            if(board[r][c])return false;
            r--;
        }
        r=row;
        c=col;
        while(r>=0 && c>=0){
            if(board[r][c])return false;
            r--;
            c--;
        }
        r=row;
        c=col;
        while(r>=0 && c<n){
            if(board[r][c])return false;
            r--;
            c++;
        }
        return true;
    }
}