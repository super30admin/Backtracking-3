// Time Complexity : O(N*M) 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Find the first character in the word
    2. Once the first character is found, do DFS on the word with all it's neighbors to find the the next letter
    3. Keep doing this until you find the last character of the word.
    4. If we don't find it then backtrack and find a differnet path
*/

// Your code here along with comments explaining your approach
class Solution {
    int rowLength;
    int colLength;
    int[][] visited;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        visited = new int[rowLength][colLength];
        return findWord(board, word);
    }
    
    public boolean findWord(char[][] board, String word) {
        for(int i=0;i<rowLength;i++) {
            for(int j=0;j<colLength;j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                     if(dfs(board, i, j, word, 1)) {
                        return true;
                     }
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, String word, int index) {
        if(index == word.length()) return true;
        for(int[] dir: dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if(isSafe(board, i, j) && board[i][j] == word.charAt(index)) {
                visited[i][j] = 1;
                if(dfs(board, i, j, word, index+1)) return true;
                visited[i][j] = 0;
            }
        }
        return false;
    }
    
    public boolean isSafe(char[][] board, int row, int col) {
        if(row<0 || col<0) return false;
        if(row >= rowLength || col >= colLength) return false; 
        if(visited[row][col] == 1) return false;
        
        return true;
    }
}
