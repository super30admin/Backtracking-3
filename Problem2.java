// Word Search(https://leetcode.com/problems/word-search/)]

// Time Complexity : O((m*n)4**L) => m*n for iterating to find first character to start dfs, and at every level, we are checking 4 directions at max=> thus 4**L
// Space Complexity : O(L) stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// start dfs with first node = first character, at every level of dfs check all possible directions, makr visited while checking a path,
//make sure to mark unvisited while backtracking, so that we can use it again in next path if we end up coming to that level by some
//other path.

class Solution {
    private int[][]dirs; int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board==null) return false;
        dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(helper(board,i,j,word,0)) return true;
            }
        }      
        return false;
    }
    private boolean helper(char[][] board, int r, int c, String word, int index){
        //base
        if(index==word.length()) return true;
        if(r<0 || c<0 || r>=m || c>=n || board[r][c]=='#') return false;
        //logic
       if(board[r][c]==word.charAt(index)){
        //action
        board[r][c] = '#';
        //recurse
        for(int[]dir : dirs){
            int nr=dir[0]+r;
            int nc =dir[1]+c;
            if(helper(board,nr,nc,word,index+1)) return true;
        }
        //backtrack
        board[r][c]=word.charAt(index);
       }
       return false;
    }
}