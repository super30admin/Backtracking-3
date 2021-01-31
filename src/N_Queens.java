// Time Complexity : O(N!)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	List<List<String>> result;
    int m;
    int [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        m = n;
        board = new int[n][n];
        backtrackHelper(0);
        return result;
    }
    
    private void backtrackHelper(int r){
        //base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    }else
                        sb.append('.');
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int c = 0; c < m; c++){
            if(isSafe(r, c)){
                //action
                board[r][c] = 1;
                //recurse
                backtrackHelper(r +1);
                //backtrack
                board[r][c] = 0;
            }
        }
    }
    
    private boolean isSafe(int r, int c){
        //column up
        for(int k = 0; k < r; k++){
            if(board[k][c] == 1) return false;
        }
        //diagonal up left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        //diagonal up right
        i = r;
        j = c;
        while(i >= 0 && j < m){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }
}
