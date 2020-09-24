//Time Complexity=O(n*n!)
//Space Complexity=O(n*m)
class Solution {
   List<List<String>>output=new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][]board=new char[n][n];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]='.';
            }
        }
        backTrack(board,0,n);
        return output;
    }
    void backTrack(char[][]board,int i,int queensLeftToPlace)
    {
        if(queensLeftToPlace<=0)
        {
            output.add(MakeOutput(board));
            return;
        }
        for(int j=0;j<board.length;j++)
        {
            if(isValidPlace(board,i,j))
            {
                board[i][j]='Q';
                backTrack(board,i+1,queensLeftToPlace-1);
                board[i][j]='.';
            }
        }
    }
    boolean isValidPlace(char[][]board,int i,int j)
    {
        int r=i;
        int c=j;
        //CheckUpward only r will change c will be constant
        while(r>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
        }
        r=i;
        c=j;
        //Check left diagonal both r and c will be decremented
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c--;
        }
        //Check right diagonal r will be decremented and c will be incremented
        r=i;
        c=j;
        while(r>=0 && c<board.length)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    List<String>MakeOutput(char[][]board)
    {
        List<String>outputList=new ArrayList();
        for(int i=0;i<board.length;i++)
        {
            String temp="";
            for(int j=0;j<board.length;j++)
            {
                temp=temp+board[i][j];
            }
            outputList.add(temp);
        }
        return outputList;
    }
}