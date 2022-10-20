class Solution {
    int m,n;
    boolean[][] grid;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
            
        grid=new boolean[m][n];
        int i,j;
        boolean ans=false;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(helper(board,word,i,j,0))
                    return true;
            }
        }
        
        return false;
        
        
        
    }
    
    private boolean helper(char[][] board, String word,int i,int j,int idx)
    {
        //base
        if(idx==word.length())
            return true;
        
        if(j<0 || i<0 || i>=m || j>=n || board[i][j]=='#' || board[i][j]!=word.charAt(idx))
            return false; 
        
        
        //logic
        
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir : dirs)
        {
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            char c=board[i][j];
            board[i][j]='#';
            if(helper(board,word,nr,nc,idx+1))
                    return true;
            board[i][j]=c;
                
                
        }
        
        return false;
        
        
    }
}


// Time Complexity : O(4^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
