/*
Author: Akhilesh Borgaonkar
Problem: Given a 2D board and a word, find if the word exists in the grid.
Approach: Used backtracking approach here. First, I explore whole grid till I find the first character of input word to be searched.
    If I find the first character then I explore only it's neighbors vertical and horizontal. Once I find the first character then,
    I call the backtrack function recursively for following characters till I reach the end of input string.
Time Complexity: O(m + 3^n) where m is the number of characters in grid and n is length of input word to be searched.
    Exponential of 3 because I always have 3 neighbors to look for. Previous neighbor will be discarded as already visited.
Space Complexity: O(n) where n is the length of search word.
LC verified.
*/

class Solution {
    private int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0 || word.length()==0)
            return false;
        int lrow = board.length;
        int lcol = board[0].length;
        for(int i=0; i<lrow; i++){
            for(int j=0; j<lcol; j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]='-';
                    if(backtrack(board, i, j, word, 1))
                        return true;
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int currIndex){

        if(currIndex == word.length())
            return true;

        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '-') {
                if (board[x][y] == word.charAt(currIndex)) {
                    board[x][y] = '-';
                    if (backtrack(board, x, y, word, currIndex + 1))
                        return true;
                    board[x][y] = word.charAt(currIndex);
                }
            }
        }
        return false;
    }
}