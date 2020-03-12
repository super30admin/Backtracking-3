// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode :NO
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean exist(char[][] board, String word) {
      int m = board.length;
      int n = board[0].length;
   
      boolean result = false;
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
             if(dfs(board,word,i,j,0)){
                 result = true;
             }
          }
      }
   
      return result;
  }
   
  public boolean dfs(char[][] board, String word, int i, int j, int k){
      int m = board.length;
      int n = board[0].length;
   
      if(i<0 || j<0 || i>=m || j>=n){
          return false;
      }
   
      if(board[i][j] == word.charAt(k)){
          char temp = board[i][j];
          if(k==word.length()-1){
              return true;
          }else if(dfs(board, word, i+1, j, k+1)
  
          ||dfs(board, word, i, j+1, k+1)){
              return true;
          }
          board[i][j]=temp;
      }
   
      return false;
  }
  }
  