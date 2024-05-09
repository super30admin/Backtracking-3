import java.util.ArrayList;
import java.util.List;


// TC: O(n * n!)
// SC: O(n^2)
public class Problem1 {
     List<List<String>> result;
    boolean[][] chessBoard;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.chessBoard = new boolean[n][n];
        helper(0,n);
        return result;
    }

    public void helper(int i, int n){
        //base 
        if(i==n){
            List<String> row = new ArrayList<>();
            for(int r=0;r<n;r++){
                StringBuilder sb = new StringBuilder();
                for(int c=0;c<n;c++){
                    if(chessBoard[r][c]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                row.add(sb.toString());
            }
        result.add(row);
        return;
        }

        //logic
        for(int j=0;j<n;j++){
            if(isSafe(i, j, n)){
                chessBoard[i][j]=true;
                helper(i+1,n);
                chessBoard[i][j]=false;
            }
        }
    }

    public boolean isSafe(int r, int c, int n){
        //bottom-up
        int i = r;
        int j = c;
        while(i>=0){
            if(chessBoard[i][j]) return false;
            i--;
        }

        //diagonal left 
        i=r;
        j=c;
        while(j>=0 && i>=0){
            if(chessBoard[i][j]) return false;
            j--;
            i--;
        }

        //diagonal right
        i=r;
        j=c;
        while(j<n && i>=0){
            if(chessBoard[i][j]) return false;
            j++;
            i--;
        }

        return true;
    }
}
