package backtracking3;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	//Time Complexity : O(n!), where n is the matrix
	//Space Complexity : O(n), for internal stack and boolean array
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(result, n, 0, new boolean[n][n]);
        return result;
    }
    
    private void helper(List<List<String>> result, int n, int row, boolean[][] place) {
        // base
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(place[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        
        // logic
        for(int col=0; col<n; col++) {
            if(isSafe(row, col, place, n)) {
                place[row][col] = true;
                helper(result, n, row + 1, place);
                place[row][col] = false;
            }
        }
    }
    
    private boolean isSafe(int row, int col, boolean[][] place, int n) {
        // check vertically up
        for(int i=0; i<row; i++) {
            if(place[i][col])
                return false;
        }
        
        // check diagonally left-up
        int r = row, c = col;
        while(r >= 0 && c >= 0) {
            if(place[r--][c--])
                return false;
        }
        
        // check diagonally right-up
        r = row; c = col;
        while(r >= 0 && c < n) {
            if(place[r--][c++])
                return false;
        }
        
        return true;
    }
}
