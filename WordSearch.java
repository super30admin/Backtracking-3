// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : Getting started

public class WordSearch {

    class Solution {
        public boolean exist(char[][] board, String word) {

            //Iterate over board and find first letter and perform DFS for other letters and return true else return false
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, int i, int j, int count, String word){
            //base case
            if(count == word.length()) return true;

            //Stop recurrsion if outside the board or cell doesn't match letter being searched for
            if(i<0 || i >= board.length || j<0 || j>= board[i].length || board[i][j] != word.charAt(count)){
                return false;
            }

            //store value in cell in temp var and mark it empty so as not to use it again
            char temp = board[i][j];
            board[i][j] = ' ';

            //perform recursion and search for the word in the neighboring cells
            boolean found = dfs(board, i+1, j, count+1, word) ||
                    dfs(board, i-1, j, count+1, word) ||
                    dfs(board, i, j + 1, count+1, word) ||
                    dfs(board, i, j -1, count+1, word);

            //restore previous value on the board
            board[i][j] = temp;

            return found;
        }
    }
}
