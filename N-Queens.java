/*
Time Complexity: O(N*M!)
Space Complexity: O(N)
*/
class Solution {
    List<List<String>> result;
    int [][]board; int m;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m=n;
        //edge
        if(n==0) return result;
        board=new int[n][n];
        backtrack(0);
        return result;
    }
    public void backtrack(int r){
        //base 
        if(r==m){
            List<String> li = new ArrayList<>();
            for(int i=0;i<m;i++){
                StringBuilder sb =new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j]==0){
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int i=0;i<m;i++){
            if(isSafe(r, i)){
                //action
                board[r][i]=1;
                //backtrack
                backtrack(r+1);
                //recurse
                board[r][i]=0;
            }
        }
    }
    public boolean isSafe(int r, int c){
        //column above
        for(int k=0;k<r;k++){
            if(board[k][c]==1) return false;
        }
        //diagonal upleft
        int i=r-1; int j=c-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--; j--;
        }
        //diagonal upright
        i=r-1; j=c+1;
        while(i>=0 && j<m){
            if(board[i][j]==1) return false;
            i--;j++;
        }
        return true;
    }
}