// Time Complexity : o(n* 2powern)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        
        if(word.length()==0)
            return true;
        if(board==null || board.length==0)
            return false;
        
       
         m=board.length;
         n=board[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]!=word.charAt(0))
                    continue;
                if(helper(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    
    
    private boolean helper(char[][] board,int r,int c,String word,int index)
    {
        if(index==word.length())
            return true;
        
        if(r<0||r>=m || c<0||c>=n || board[r][c]!=word.charAt(index))
            return false;
        
      int[][]  dirs=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        
        char temp=board[r][c]; // storing orginal char to temp
        board[r][c]='#'; // mark # as visited
        
        for(int[] dir:dirs)
        {
            int nR=r+dir[0];
            int nC=c+dir[1];
            
            if(helper(board,nR,nC,word,index+1)) // recurse till u search the final word
                return true;
        }
        
        board[r][c]=temp; // backtrack if choosen path doesnt include valid path and restore orginal character instead of #.
        
        return false;
    }
}