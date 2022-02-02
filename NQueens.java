// Time Complexity : O(n!)
// Space Complexity : O(n2)
class Solution {
    List<List<String>> result;
    int N;
    boolean board[][];
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        if(n==0)
            return result;
        N=n;
        board=new boolean[n][n];
        backtrack(0);
        return result;
    }
    private void backtrack(int row){
        //base
        if(row==N){
            List<String> sol=new ArrayList<>();
            for(int i=0;i<N;i++){
                StringBuilder res=new StringBuilder();
                for(int j=0;j<N;j++){
                    if(board[i][j])
                        res.append("Q");
                    else
                        res.append(".");
                }
                sol.add(res.toString());
            }
            result.add(sol);
        }
        //logic
        for(int i=0;i<N;i++){
            if(isSafe(row,i)){
                board[row][i]=true;
                backtrack(row+1);
                //backtrack
                board[row][i]=false;
            }
        }
    }
    private boolean isSafe(int i, int j){
        //for coulumn
        for(int c=0;c<i;c++){
            if(board[c][j]== true)
                return false;
        }
        int r=i;
        int c =j;
        while(r>=0 && c>=0){
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        
        
        r=i;
        c=j;
        while(r>=0 && c<N){
            if(board[r][c])
                return false;
            r--;
            c++;
        }
       return true;     
    }
}
