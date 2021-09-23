// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    private int [][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        m = board.length; n = board[0].length;
        dirs = new int[][] {{-1,0}, {0,-1}, {1,0}, {0,1}};
        for(int i=0; i< m; i++){
            for(int j=0; j<n ; j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        // base
        if(i <0 || j<0 || i==m || j==n || board[i][j] == '#') return false;
        if(index == word.length()) return false;
        // logic
        if(word.charAt(index) == board[i][j]){
            if(index == word.length()-1) return true;
            // action -> make it visited
            char ch = board[i][j];
            board[i][j] = '#';
            // recursion
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board, word, r, c, index+1)) return true;
            }
            // backtrack
            board[i][j] = ch;
        }
        return false; //if from none of the neighbors we can form the word
    }
}