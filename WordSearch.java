/*
Time Complexity : O(M.N.3^L) where M and N are the rows and cols in the board. At each cell, there are 3 neighbors that need
to be explored.
Space Complexity : O(L) in the recursion stack, the entire length of the word
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :

We need to perform dfs on each cell that matches the first char of the word. To mark the cell visited, we can change the char
to "#". Once a path is explored we need to back track as that particular character can appear in the word later, so our path need
to visit the character and then un-visit it. So once all the children are explored for a character in the board, will unmark
by restoring its previous value.

*/
public class WordSearch {
    int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordExist(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean wordExist(char[][] board, int i, int j, String word,int index){
        int rows = board.length;
        int cols = board[0].length;
        // If we reach end of the given word, we return true as all the characters in the word are matched
        if(index == word.length()) return true;

        // If we reach the board boundaries, we return false. We have explored all cells in the direction.
        if(i < 0 || j < 0 || i == rows || j == cols) return false;
        if(board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';
        for(int [] dirs: directions){
            int newRow = dirs[0] + i;
            int newCol = dirs[1] + j;
            if(wordExist(board, newRow, newCol, word, index+1)){
                return true;
            }
        }
        // backtrack
        board[i][j] = temp;
        return false;
    }
}
