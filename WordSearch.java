//Time Complexity=O(n*m*n*m)
//Space Complexity=O(n*m)//Recursive stack
class Solution {
    public boolean exist(char[][] board, String word) {
       if(board.length==0||board==null||board[0].length==0||word==null||word.length()==0)
        {
            return true;
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                //Start backtracking only when the first word of string is in board
                if(board[i][j]==word.charAt(0))
                {
                   if(backTrack(board,i,j,word,0))
                   {
                    return true;
                   }
                }
            }
        }
        return false;
    }
    
    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    boolean backTrack(char[][]board,int i,int j,String word,int index)
    {  
        //We do word length-1 because we do index+1 while backtracking
        if(index>=word.length()-1)
        {
            return true;
        }
        //We need to temp to change the value to same once we finish backtracking
        char temp=board[i][j];
        board[i][j]='#';
        
        for(int[]dirs:direction)
        {
            int r=dirs[0]+i;
            int c=dirs[1]+j;
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && (index+1<word.length())&& board[r][c]==word.charAt(index+1))
            {
                if(backTrack(board,r,c,word,index+1))
                {
                 return true;
                }
            }
        }
        board[i][j]=temp;
        return false;
    }
}