// Time Complexity : O((m*n)*3^L), Three directions traversed for each charcter of a string wth length L.(m*n) to find the beginning cahracter(worst case).
// Space Complexity : O(L), Lengthof the word OR The depth of the recursive stack.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    String str;
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0)return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0))return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int r, int c, int index){
        //base
        if(index==word.length())return true;
        System.out.println("Hello");
        if(r<0 || c<0 || r==m || c==n || board[r][c]=='#')return false;
        System.out.println("Hello");
        //logic
        if(board[r][c]== word.charAt(index)){
           //action
           char ch = board[r][c];
           board[r][c] = '#';
           //Now do recursion
           for(int[] dir: dirs){
               int newr = r + dir[0];
               int newc = c + dir[1];
               if(backtrack(board,word,newr,newc, index +1)){
                   return true;  
               }
           }
           //backtrack
           board[r][c] = ch;
        }
        return false;
    }
}