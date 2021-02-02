# BackTracking-3

## Problem2
Word Search(https://leetcode.com/problems/word-search/)
// Time Complexity : O(m*n*3^n)
// Space Complexity : no space required
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
// find the find letter of the word in the grid by Traversing the whole grid.. if found.. make char at [i][j] to '.'.
// Secondly check its neighbours for next letters and so.  if not found backtrack. 
class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;  n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board, word, i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word,int i,int j,int index){
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        //base
        if(index==word.length()){
            return true;
        }
        if(i<0 || j<0 || i==m || j==n || board[i][j]=='.'){
            return false;
        }
        
        if(word.charAt(index)==board[i][j]){
            char temp = board[i][j];
            board[i][j]='.';
            for(int[] dir:dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board, word, r,c,index+1)){
                    return true;
                }
            }
            board[i][j]=temp;
        }
        return false;
    }
}