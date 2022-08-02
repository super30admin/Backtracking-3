// time exponentional
// space 0(l)
class Solution {
    int m;
    int n;
    int [][]dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0)
        {
            return false;
        }
        m =board.length;
        n=board[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtracking(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;

    }
    private boolean backtracking(char[][] board, String word, int row, int col, int index)
    {
        if(index==word.length())
        {
            return true;
        }
        if(row<0 || col<0 || row==m || col==n || board[row][col]=='#')
        {
            return false;
        }

        if(board[row][col]==word.charAt(index))
        {
            char ch=board[row][col];
            board[row][col]='#';
            for(int[] dir:dirs)
            {
                int nr=dir[0]+row;
                int nc=dir[1]+col;
                if(backtracking(board,word,nr,nc,index+1))
                {
                    return true;
                }
            }
            board[row][col]=ch;
        }
        return false;
    }
}

