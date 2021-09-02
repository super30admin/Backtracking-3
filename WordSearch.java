
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach:
1) In this, we traverse through the board and check for the letters in the word. If the character in word is present then DFS starts and we check for every word
2) Once we find the solution we return true and stop DFS.
3) we use backtracking in this process. when we initially visit the character and if it exists, then we mark the character as # or with any other character
4) once we return after traversing we nake it back to what it was, thus allowing other characters to be traversed when we start with another character.
*/



public class WordSearch {
    
    public boolean exist(char[][] board, String word) {
      
        if(board==null || board.length==0 || word.length()==0 || word==null)
            return false;
        
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,i,j,0,word,visited))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, int index, String  word,boolean[][] visited)
    {
        if(index>=word.length())
            return true;
        
        
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(index) || visited[row][col]==true)
        {
            return false;
        }
        
        visited[row][col]=true;
        
        boolean res= dfs(board,row+1,col,index+1,word,visited)|| dfs(board,row-1,col,index+1,word,visited) || dfs(board,row,col-1,index+1,word,visited) || dfs(board,row,col+1,index+1,word,visited);
        
        visited[row][col]=false;
        
        return res;
        
    }
    

}
