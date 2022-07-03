import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(N!)
//Space Complexity: O(1)
public class nQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        boolean[][] board = new boolean[n][n];
        helper(board, 0, n);
        return result;
    }

    public void helper(boolean[][] board, int r, int n){
        //base
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i=0; i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        // logic
        for(int j=0; j<n; j++){
            if(isSafe(board, r, j, n)){
                board[r][j] = true;
                helper(board, r+1, n);
                board[r][j] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] board, int r, int c, int n){
        for(int i=0; i < r; i++){
            if(board[i][c]) return false;
        }
        int i = r; int j = c;
        while(i >= 0 && j>=0){
            if(board[i][j])return false;
            i--;
            j--;
        }
        i = r;
        j = c;
        while(i >= 0 && j <n){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        return true;

    }
}
