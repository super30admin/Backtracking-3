// Time Complexity : O(N!)
// Space Complexity : O(NxN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];		// to maintain the visited array
        placeQueens(board, 0, n);			// recursively check all possible placements
        return result;
    }
    
    private void placeQueens(int[][] board, int r, int n){
        
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){			// if we find a 1 in visited matrix, add a Q in the string or else "."
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());		// add to the string and then to the result
            }
            result.add(li);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isSafe(board, r, i, n)){		// check if the placement is safe to proceed further
                board[r][i] = 1;
                placeQueens(board, r+1, n);		// recursively call on each row and change to 1 if we visited and when backtracking change the 1 to 0 if it's not the preferred path
                board[r][i] = 0;
            }   
        }
    }
    
    private boolean isSafe(int[][] board, int i, int j, int n){
        for(int k = 0; k < i; k++){		// base case
            if(board[k][j] == 1){
                return false;
            }
        }
        
        int x = i - 1;
        int y = j - 1;	
        while(x >= 0 && y >= 0){			// move diagonally to the left top
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }
        
        x = i - 1;
        y = j + 1;
        while(x >= 0 && y < n){				// move diagonally to the right top
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
}