//Time Complexity=O(n)
//Space Complexity=O(n^2)
public class NQueen {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        helper(board,0,n);

        return result;
    }

    private void helper(boolean [][] board,int r,int n){
        //base
        if(r==n){
            List<String>li= new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //logic
        for(int j=0;j<n;j++){
            if(isSafe(board,r,j,n)){
                //Action
                board[r][j]=true;

                //Recurse
                helper(board,r+1,n);

                //Backtrack
                board[r][j]=false;
            }
        }
    }
    private boolean isSafe(boolean[][]board,int r,int c,int n){

        for(int i=0;i<n;i++){
            if(board[i][c]) return false;
        }

        int i=r,j=c;

        while(i>=0 && j>=0){
            if(board[i][j]==true) return false;
            i--;j--;
        }
        i=r;j=c;
        while(i>=0 && j<n){
            if(board[i][j]==true) return false;
            i--;j++;
        }
        return true;
    }
}
