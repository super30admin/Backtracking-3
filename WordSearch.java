// Time Complexity: O(m*n*3^l)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * The idea is to iterate over the entire matrix and find the 1st character in the word. Once we find the 1st character,
 * we need to perform DFS from there. Instead of using a visited array, we can save space by in-place adjustment
 * by placing '#'. Important points in this problem:
 * 1 - We can only use DFS and not BFS because we have to perform backtracking and for backtracking, we need
 * to know the path. In DFS, we have a fixed path but in BFS, we have all the nodes instead of one so the
 * path is not fixed and we do not know what to backtrack exactly.
 * 2 - Regrading TC: Matrix iteration + DFS
 * 3 - Space complexity - Replacing it with # will reduce space requirement
 */

public class WordSearch {
        
    private int [][] dirs;
    int m;
    int n;
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(word.charAt(0) == board[i][j])
                {
                    if(backtrack(board,word,0,i,j))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int index, int i,int j)
    {
        //base
        if(index == word.length())
            return true;
        
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        
        //logic
        if(board[i][j] == word.charAt(index))
        {
        for(int dir[]:dirs)
            {
                int r = i + dir[0];
                int c = j + dir[1];
                //action
                board[i][j] = '#';
                //recurse
                if(backtrack(board,word,index + 1,r,c))
                    return true;
                //backtrack
                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }
}
