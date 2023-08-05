// Time Complexity :O(3^k m*n) where K is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in bracktracing of chose not choose on the board in al 4 directions

class Solution {
        int m;
        int n;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
         m = board.length;
         n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(backtracking(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, String word,int i, int j, int idx){
        if(idx == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=board.length || j >= board[0].length || board[i][j] == '#'){
            return false;
        }

        if(word.charAt(idx) == board[i][j]){
            board[i][j] = '#';
            for(int[] dir: dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(backtracking(board,word,r,c,idx+1)) return true;
            }
             board[i][j] = word.charAt(idx);
        }
        return false;
    }
}