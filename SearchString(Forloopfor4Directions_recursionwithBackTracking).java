// Time Complexity : (n.3^l) n = no of cells in matrix , l = no of letters in word
// Space Complexity :O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not sure about space complexity


// Your code here along with comments explaining your approach
//1 Start from index 0,0 and call recursive function
//2. if letter at i,j matches with letter at current index of word then proceed and check next letter in all four directions (clockwise) 
// 3 if letter at i, j doesnt match then backtrack (means make this index unvisited)
// keep calling recursive function untill all letters of given word are covered or reaches at end of matrix


class Solution {
    int m ;
     int n;
    //int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
       int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board == null || word.length() ==0 || word == "")
             return false;
        m = board.length;
        n = board[0].length;
        
        for(int i = 0 ; i < m; i ++)
        {
            for (int j = 0 ; j < n ; j++)
            {
              if(dfs(board, word, i, j , 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word , int i , int j , int index)
    {
        // base
        if(i < 0 || i == m || j < 0 || j == n || board[i][j] == '#' )
            return false;
        
        if(index == word.length())  
            return true;
        
        // action
        if(board[i][j] == word.charAt(index))
        {
            if( index == word.length()-1)
               return true;
            char ch = board[i][j];
            board[i][j] = '#';
        
            for(int[] dir : dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];

                 if(dfs(board,word,r,c,index+1) ) return true;
            }

            // backtrack
            board[i][j] = ch;
        }
        
        return false;
    }
}