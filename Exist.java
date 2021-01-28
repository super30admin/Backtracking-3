// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    boolean[][] visited;
    String w;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {

        if(word == null || word.length() == 0){
            return false;
        }

        if(board == null || board[0] == null){
            return false;
        }

        m = board.length;
        n = board[0].length;

        w = word;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        visited = new boolean[m][n];

        // check at every cell
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(backTrack(board,0,i,j,dirs)){
                    return true;
                }

            }
        }

        return false;

    }

    public boolean backTrack(char[][] board,int index,int row,int column,int[][] dirs){

        // If word can be formed
        if(index == w.length()){
            return true;
        }

        // Base case
        if(row < 0 || row == m || column < 0 || column == n || visited[row][column] || board[row][column] != w.charAt(index)){
            return false;
        }

        visited[row][column] = true;

        for(int i=0;i<dirs.length;i++){

            int nextRow = row + dirs[i][0];
            int nextColumn = column + dirs[i][1];

            // backtrack on the next cell
            if(backTrack(board,index+1,nextRow,nextColumn,dirs)){
                return true;
            }

        }

        visited[row][column] = false;

        return false;
    }
}