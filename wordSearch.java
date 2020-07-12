// Time Complexity : O(m*n*3^l)  m - number of rows n - number of columns
// Space Complexity : O(l) l - length of the word
// Did this code successfully run on Leetcode : Yes
class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dfs(board,word,m,n,i,j,0,' '))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board,String word,int m,int n,int i,int j,int s,char c)
    {
        if(s==word.length()) return true;
        
        if(i==m ||i<0 || j==n || j<0 || board[i][j]!=word.charAt(s)) return false;
        
        //action
        c=board[i][j];
        board[i][j]='.';
        
        //recurse
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs)
        {
           if(dfs(board,word,m,n,i+dir[0],j+dir[1],s+1,c)) return true; 
        }   

        //backtracking
        board[i][j]=c;
        
        return false;
        
    }
}