//Time Complexity: O(m*n*3^n)
//Space Complexity: O(n^2)

class Solution {
    
    private int dirs[][];
    
    int m;
    int n;
    
    public boolean exist(char[][] board, String word) {
        
        m = board.length;
        n = board[0].length;
        
        
        if(board==null || board.length==0)
        {
            return false;
        }
        
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char board[][], String word,int r,int c,int index)
    {
        //base
        
        if(index == word.length())
        {
            return true;
        }
        
        if(r<0 || r==m || c<0 || c==n || board[r][c]=='#')
        {
            return false;
        }
        
        //logic
        if(board[r][c] == word.charAt(index))
        {
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            
            //recurse
            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if(backtrack(board,word,nr,nc,index+1))
                {
                    return true;
                }
            }
            
            //backtrack
            board[r][c] = ch;
        }
        
        return false;        
    }
}