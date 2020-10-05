// Time Complexity : O(m*n)since we have a for loop for dfs O(m*n) since we may have to search for entire matrix for each iteration

// Space Complexity : O(n) where n is the stack space (the length of the word)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
for each and every i,j in the matrix we will run the dfs since it could be the starting position
if the dfs returns true we return true

this dfs function takes in params (start -> start index of string,board,row,col and the word )
this can be done using global variables as well

the base case will be if start index is == length
 
else we will return false if out of bounds or the character expected is not what we get

else we there is match so far and so 
1)now mask it with '#'
2) run for all dir in dirs and see recursively if i+1 letter matches somehwhere(using this same logic on negihbours)
3) once the recursively called dfs is finished , place the original char since element at this (i,j) could be useful for others

4)if we have reached till here that means everything has exhausted so return false for this dfs


*/
class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                if (dfs(0, board, i, j, word))
                    return true;
            }
        }

        return false;
    }

    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean dfs(int start, char[][] board, int i, int j, String word) {

        if (start == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(start))
            return false;

        board[i][j] = '#';
        for (int dir[] : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (dfs(start + 1, board, r, c, word))
                return true;

        }
        board[i][j] = word.charAt(start);
        return false;

    }
}