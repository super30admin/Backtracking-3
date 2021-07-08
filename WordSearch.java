// Time Complexity : O(n * 4^L) where n is the number of characters in the matrix and L is the length of the word 
// Space Complexity : O(L) (or) O(n) where n is number of characters and L is the length of the word 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didnt realise DFS would make it into infinite loop
/* Your code here along with comments explaining your approach: Get the starting point as the letter from which the word starts. Start the recursion
from there and get into neighbor characters. Make sure if the neighbor character matches the word character, mark the visited character as & (Arbitary symbol)
and keep on searching the next letter of the word till you reach either out of the bounds, or you face a & which means that the letter has been 
visited before and hence we need to backtrack here. Once you backtrack, you explore new and different directions from where you started. As you
backtrack, you change all the visited & back to its original character stored as prev. Once you reach end of the word => word has been found. */
// BACKTRACKING
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){return false;}
        for(int i = 0; i < board.length; i++)
        {for(int j = 0; j < board[0].length; j++){
            if(board[i][j]==word.charAt(0)){                                // As you get the start point   
                if(backtrack(board, word, i, j, 0)){return true;}                       // Start the recursion
            }
        }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int k){
       if(k >= word.length()){return true;}                                                     // Reaches end of the word means word has been found
       if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
          || board[i][j] == '&'){return false;}                                                     // Out of bounds or visiting the visited character means start backtrack

        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        if(board[i][j] == word.charAt(k)){                                                          // Matches with kth word character
            char prev = board[i][j];                                                        // Mark the character so that we can backtrack here 
            board[i][j] = '&';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(backtrack(board, word, r, c, k+1)){return true;}                             // Explore
        }
        board[i][j] = prev;                                                             // Backtrack to the original character
    }
        return false;
    }
}