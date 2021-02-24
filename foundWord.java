// Time Complexity : O(n*m * 3^l) l is word length
// Space Complexity : O(n*n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(foundWord(board, i , j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean foundWord(char[][] board, int i , int j, String word, int k) {
        
        if(i<0 || i==board.length || j<0 || j== board[0].length || board[i][j]=='#' || board[i][j]!=word.charAt(k)) return false;
        
        if(k==word.length()-1) return true;
        
        board[i][j] = '#';
        boolean flag =  foundWord(board, i+1 , j, word, k+1) ||
                        foundWord(board, i , j+1, word, k+1) ||
                        foundWord(board, i-1, j, word, k+1) ||
                        foundWord(board, i , j-1, word, k+1);
        
        board[i][j] = word.charAt(k);
        
        return flag;
    }
    
}
