/**Leetcode Question number 79 - Word Search */
/**Algorithm - Backtracking
 * Pass the board, word, row, column of the board and the strating index of the word to the backtrack function
 * if the character at the position of the board is equal to the index of the word, 
 * store the current letter of the board in a temo variable and mark it as visited on the board
 * Check for the base conditions in all the recursive calls
 */
/**TC - O(3^N)
 * SC - O(N) = N= length of the word which goes in the recursion stack
 */
public class WordSearch {
    class Solution {
        boolean result;
        int m, n;
        public boolean exist(char[][] board, String word) {
            if(board == null || board.length ==0){
                return false;
            }
            if(word.length() == 0 || word == null){
                return true;
            }
            m = board.length;
            n = board[0].length;
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                        if(backtrack(board,word, i, j, 0)){
                            return true;
                        }
                    }
                }
            return false;
        }
        private boolean backtrack(char[][] board, String word, int i, int j, int index){
            //base
            if(index == word.length()){
                return true;
            }
            if(i<0 || i==m || j==n || j<0 || board[i][j] == '0'){
                return false;
            }
            
            //logic
            int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
            if(board[i][j] == word.charAt(index)){
                char temp = board[i][j];
                board[i][j] = '0';
                for(int[] dir: direction){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(backtrack(board,word, r,c, index +1)){
                    return true;
                    }
                } 
                board[i][j] = temp;
            }
            return false;
        } 
    }
}
