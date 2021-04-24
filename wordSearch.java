// N : total no fo cells in the matrix
// Time Complexity : O(N*3^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int[][] dirs;
    String word;
    int m,n;
    public boolean exist(char[][] board, String word) {
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.word = word;
        m = board.length;
        n = board[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(DFS(board,i,j,0)) return true;
                }
            }
        }
        return false;
        
    }
    private boolean DFS(char[][] board, int i, int j,int index){
        if(index == word.length())
            return true;
        //System.out.println(i+" "+j);
        if(i <0 || i>=m || j <0 || j>=n || board[i][j] != word.charAt(index))
            return false;
        board[i][j] = '#';
        for(int dir[]:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
               if(DFS(board,r,c,index+1)) return true;
        }
        board[i][j] = word.charAt(index); 
        return false;
    }
}