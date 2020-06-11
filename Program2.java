package LeetCode;
/*
 * 
 * 
 * TC = O(n*2^n)
 *  SC = O(n) 
 * 
 * */
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        char [] words = word.toCharArray();
        
        //for every point in the 2d array we do dfs and if for any point we are able to given word we return true for that point.
        for(int i=0;i<board.length; i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                if(dfs(i,j,board,0,words)) return true;
            }
            
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][]board, int index, char[] words)
    {
        if(i<0|| i>=board.length || j<0 || j>=board[i].length || board[i][j] == '.' || words[index] != board[i][j])
        return false;
        char c = board[i][j]; //this will help to restore the character at i,j from '.' to its original value in case all the characters in words are not exhausted starting from i,j
        boolean res = false;
        if(index == words.length-1) return true; // if index is able to reach the end of words array then it means it has successfully found all characters in that words array
        board[i][j] = '.';//mark the i,j point and move forward, note this has to be restored back if we are not fullly exhausting the words array
     
      res = dfs(i+1,j,board,index+1,words) || 
            dfs(i-1,j,board,index+1,words) ||
            dfs(i,j+1,board,index+1,words) ||
            dfs(i,j-1,board,index+1,words);
        
        board[i][j]=c; 
        
        return res;
    }
}