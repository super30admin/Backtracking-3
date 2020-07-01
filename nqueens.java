//Time complexity:O(N^N/2)
//Space complexity:O(N)

class Solution {
    int m;
    int[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        m=n;
        result=new ArrayList();
        if(n==0){
            return result;
        }
        board=new int[n][n];
        backtrack(0);
        return result;
    }
    
    private void backtrack(int row){
        //base
        if(row==m){
        List<String> temp=new ArrayList();
        for(int i=0;i<board.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==1){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            temp.add(sb.toString());
        }
            result.add(temp);
        }
        
        //logic
        for(int i=0;i<m;i++){
            if(isSafe(row,i)){
                board[row][i]=1;
                backtrack(row+1);
                board[row][i]=0;
            }
        }
        
    }
    private boolean isSafe(int r,int c){
        //top
        for(int k=0;k<r;k++){
            if(board[k][c]==1){
                return false;
            }
        }
        //diagonal left
        int i=r-1;
        int j=c-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i--;
            j--;
        }
        //diagonal right
        i=r-1;
        j=c+1;
        while(i>=0 && j<m){
            if(board[i][j]==1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}