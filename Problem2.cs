// Time Complexity : O(m*n*4^L)
// Space Complexity : O(L) where L is the length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I traverse through the board and call the helper method on the cell with position (i,j) if the character at that cell is the same as 
the first character of the word

Helper Function - 
Base Condition - If index = word.Length, return true
If i or j are out of bounds of board or word[index] != character in the board, return false

Core Logic - 
1. Save character at the current cell of the board to a variable
2. Mark this cell as visited (board[i][j] = '#')
3. Call Helper function on all 4 directional neighbours by incrementing index by 1
4. Backtrack by setting the cell back to the saved character
*/

public class Solution {
    int rows;
    int columns;
    public bool Exist(char[][] board, string word) {
        rows = board.Length;
        columns = board[0].Length;
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(board[i][j] == word[0])
                {
                    if(Helper(board, word, 0, i, j))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public bool Helper(char[][] board, string word, int index, int i, int j)
    {
        // Base Condition
        if(index == word.Length)
        {
            return true;
        }

        if(i<0 || i>=rows || j<0 || j>= columns || word[index] != board[i][j])
        {
            return false;
        }

        char ch = board[i][j];

        board[i][j] = '#';

        bool result = Helper(board, word, index + 1, i, j + 1) ||
        Helper(board, word, index + 1, i, j - 1) ||
        Helper(board, word, index + 1, i + 1, j) ||
        Helper(board, word, index + 1, i - 1, j);

        board[i][j] = ch; 

        return result;
    }
}