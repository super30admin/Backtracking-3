import java.util.ArrayList;
import java.util.List;

//Time Complexity = O(n^2)
//Space complexity = 0(n*n!)
public class Nqueens {
    class Solution {
        List<List<String>> result;
        public List<List<String>> solveNQueens(int n) {
            this.result = new ArrayList<>();
            boolean[][] b = new boolean[n][n];
            helper(b, 0, n);
            return result;
        }

        public void helper(boolean[][] b, int r, int n){

            if(r==n){
                List<String> li = new ArrayList<>();
                for(int i=0; i<n; i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j=0; j<n; j++){
                        if(b[i][j]){
                            sb.append('Q');
                        }
                        else{
                            sb.append('.');
                        }
                    }
                    li.add(sb.toString());
                }
                result.add(li);
            }

            for(int j=0; j<n; j++){
                if(isSafe(b,r,j)){
                    b[r][j]=true;
                    helper(b, r+1, n);
                    b[r][j]=false;
                }
            }
        }

        public boolean isSafe(boolean[][] b, int r, int c){
            //checking column
            for(int i = 0; i<r; i++){
                if(b[i][c]){return false;}
            }
            int i=r; int j=c;
            while(i>=0 && j<b.length){
                if(b[i][j]) return false;
                i--; j++;
            }
            i=r; j=c;
            while(i>=0 &&j>=0){
                if(b[i][j])return false;
                i--; j--;
            }
            return true;
        }
    }
}
