// Time Complexity: at each row we have possible number of restriction on n - 2^i where i is row num => tends to n! solution
// Space Complexity: a board matrix taken with O(n^2) space complexity
// Did you complete it on leetcode: Yes
// Any problems faced: Understood in class

// Write your approach:
// Idea here is to start dfs on each row and placing queen if it is safe for that row,
// first placing queen on 1st column of 1st row and start checking safety for 2nd row
// and placing on appropriate cell by updating board[i][j] = true
// if in further recursion we have not reached last row
// backtrack and remove queen from previous place and place it on
// next safe place in same row. When we reach base condition of reaching last row
// we safe the path into result
class Solution {
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        dfs(0);
        return result;
    }
    
    public void dfs(int r) {
        // base
        if(r==board.length) {
            List<String> path = new ArrayList<>();
            for(int i=0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j]==true) sb.append('Q');
                    else sb.append('.');
                }
                path.add(sb.toString());
            }
            result.add(new ArrayList(path));
        }
        // logic
        for(int j = 0; j<board.length; j++) {
            if(isSafe(r,j)) {
                board[r][j] = true;
                dfs(r+1);
                board[r][j] = false;
            }
        }
        
    }
    
    public boolean isSafe(int r, int c) {
        for(int i = 0; i<r; i++) {
            if(board[i][c]==true) return false;
        }
        int i = r, j= c;
        while(i>=0 && j>=0) {
            if(board[i][j]==true) return false;
            i--; j--;
        }
        i = r; j = c;
        while(i>=0 && j<board.length) {
            if(board[i][j]==true) return false;
            i--; j++;
        }
        return true;
    }
}