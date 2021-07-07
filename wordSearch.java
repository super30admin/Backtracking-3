//Time Complexity: O(N) //amount of recurssive call worst case will be all the elements on the board so N
//SPace COmplexity: O(N) //because the word we are looking for might need us to look up the whole board so worst case O(N)
//tried on leetcode and accepted
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length; i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                //if the value is same as the first character of the given word and the dfs for checking all other characters return true    //the dfs takes board, i,j count=0 and the word to be searched as input
                if(board[i][j]==word.charAt(0) && dfs(board, i, j, 0,word))
                {
                    //word found in board
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word)
    {
        //Return true if checked the whole word
        if(count == word.length())
        {
            return true;
        }
        //Check for boundry conditions
        if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=word.charAt(count))
        {
            return false;
        }
        //store the value at ij in temp variable
        char temp = board[i][j];
        //Make it empty string
        board[i][j]=' ';
        //check if found check if next letter in word found at adjacent positions
        boolean found = dfs(board, i+1,j, count+1,word)
                     || dfs(board, i-1,j, count+1,word)
                     || dfs(board, i,j+1, count+1,word)
                     || dfs(board, i,j-1, count+1,word);
        //store the original value back at ij
        board[i][j] = temp;
        //return if found or not
        return found;
    }
}