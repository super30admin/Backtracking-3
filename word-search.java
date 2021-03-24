// Time Complexity :
O(N * 3 ^L) where N is the no.of grids in the given board and 
L is the length of the word
// Space Complexity :
The maximum length of the recursion stack would be the length of the word. So, it O(L)
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean exist(char[][] board, String word) {
      //sanity check
        if(board == null || board.length == 0){
            return false;
        }
        
      //check for all characters in given word
        for(int i =0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(word.charAt(0) == board[i] [j]
                  && helper(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word,int ind, int i,int j){
        if(ind == word.length()) return true;
        //Base case 2
        if(i < 0 || i>= board.length || j<0 || j >= board[0].length) {
            return false;
        }
        //base case 3
        if(board[i][j] != word.charAt(ind)) return false;
        
        char temp = board[i][j];
        //mark the character found as visited
        board[i][j] = '*';
        //check down
        if(helper(board,word,ind + 1,i+1,j) ||
        //check up
        helper(board,word,ind + 1,i-1,j) ||
        //check left
        helper(board,word,ind + 1,i,j-1) ||
        //check right
        helper(board,word,ind + 1,i,j+1)) return true;
        /*if all the recursive calls are done then reset the marked character in grid*/
        board[i][j]=temp;
        
        //if nothing works return false
        return false;
    }
}