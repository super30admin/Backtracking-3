
// Runtime complexity - O(N . 3^L) where N is the (r*c) in my code, the total number of elements in the board. 3 because those are the directiions we will go, not cnsidering where we came from.
//Space complexity - O(W) - length of the word to be matches (recursion stack height) 
class Solution {
    int r;
    int c;
    public boolean exist(char[][] board, String word) {
       if(board==null || board.length==0)
           return false;
        if(word==null)
            return false;
        r=board.length;
        c=board[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
               if(helper(board,word,0,i,j))
                   return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board,String word,int index,int x,int y)
    {
        //base
        if(index==word.length())
            return true;
        if(x<0 || y<0 || x>=r||y>=c || board[x][y]=='#')
            return false;
        //recursion
        if(board[x][y] == word.charAt(index))
        {
            int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
            char temp=board[x][y];
            board[x][y]='#';
            for(int[] dir:dirs)
            {
                if(helper(board,word,index+1,x+dir[0],y+dir[1]))
                {
                    return true;
                }
            }
            board[x][y]=temp;
        }
        return false;
    }
}
